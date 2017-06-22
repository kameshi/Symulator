package komunikacja;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import bazaDanych.ObslugaBazyDanych;
import dane.*;
import org.apache.log4j.Logger;


public class Komunikacja implements Runnable{

    private final static Logger logger = Logger.getLogger(Komunikacja.class);
    
    BazaHistoria bazaHistoria = new BazaHistoria();
    BazaDanych baza = new BazaDanych();
    ObslugaBazyDanych obslugaBazy = new ObslugaBazyDanych();
    private int Port;
    private Socket gniazdoKlienta;
    private ObjectOutputStream pisarz;
    private ObjectInputStream czytelnik;
    private String host;

    public Komunikacja(int port, String host, Socket gniazdoKlienta) {
        Port = port;
        host = host;
        this.gniazdoKlienta = gniazdoKlienta;
    }

    public void run() {
        System.out.println("Serwer startuje na hoscie " + host);
        try {
            pisarz = new ObjectOutputStream(gniazdoKlienta.getOutputStream());
            pisarz.flush();
            czytelnik = new ObjectInputStream(gniazdoKlienta.getInputStream());
            String semafor;
            try{
                semafor = (String) czytelnik.readObject();

                if(semafor.equals("nowe")){
                    noweAuto();
                }else if(semafor.equals("stare")){
                    stareAuto();
                }else if(semafor.equals("historia")){
                    historia();
                }else if(semafor.equals("usun")) {
                    usun();
                }
            }catch(Exception ex){
                logger.error("Wyjatek serwera",ex);
            }
            pisarz.close();
            czytelnik.close();
            gniazdoKlienta.close();
        }
        catch (Exception e) {
            logger.error("Wyjatek serwera",e);
        }
    }
    private void stareAuto(){
        boolean kontrol = false;
        String nrRejestracyjny = null;
        Historia historia = null;
        try {
            nrRejestracyjny = (String) czytelnik.readObject();
        } catch (IOException e) {
            logger.error("Brak sterownika",e);
        } catch (ClassNotFoundException e) {
            logger.error("Brak sterownika",e);
        }
        try {
            historia = (Historia) czytelnik.readObject();
        } catch (IOException e) {
            logger.error("Brak sterownika",e);
        } catch (ClassNotFoundException e) {
            logger.error("Brak sterownika",e);
        }
        baza = obslugaBazy.odczytSamochodu();
        for(int i = 0; i < baza.size(); i++) {
            if (nrRejestracyjny.equals(baza.getRejestracja(i))) {
                historia.setIdRejestracja(baza.getIdRejestracja(i));
                kontrol = true;
                break;
            }
        }
        if(kontrol) {
            bazaHistoria = obslugaBazy.odczytHistori();
            Integer max = bazaHistoria.size()+1;
            historia.setIdHistoria(max.toString());
            obslugaBazy.zapisHistoria(historia);
        }
        rozeslanie(kontrol);
    }
    private void noweAuto(){
        DaneAuta auto = null;
        try {
            auto =(DaneAuta) czytelnik.readObject();
        } catch (IOException e) {
            logger.error("Brak sterownika",e);
        } catch (ClassNotFoundException e) {
            logger.error("Brak sterownika",e);
        }
        Boolean kontrol = true;
        baza = obslugaBazy.odczytSamochodu();
        Integer max = baza.size() + 4;
        if (obslugaBazy.szukajAuta(auto , baza)) {
            auto.setIdRejestracja(max.toString());
            obslugaBazy.zapisRejestracji(auto);
            kontrol = false;
        }
        if(kontrol){
            auto.setIdRejestracja(max.toString());
            obslugaBazy.zapisRejestracji(auto);
        }
        rozeslanie(kontrol);
    }
    private void historia(){
        boolean kontrol = true;
        if(bazaHistoria.size() < 0){
            kontrol = false;
        }else {
            bazaHistoria = obslugaBazy.odczytHistori();
            rozeslanie(bazaHistoria);
        }
        rozeslanie(kontrol);
    }
    private void usun(){
        String[] dane = new String[3];
        for(int i = 0; i < 3; i++){
            try {
                dane[i] = (String) czytelnik.readObject();
            } catch (IOException e) {
                logger.error("Brak sterownika",e);
            } catch (ClassNotFoundException e) {
                logger.error("Brak sterownika",e);
            }
            System.out.println(dane[i]);
        }
    }
    private void rozeslanie(BazaHistoria baza){
            try{
                pisarz.writeObject(baza);
            }catch(Exception ex){ex.printStackTrace();}
    }
    private void rozeslanie(boolean zmienna){
        try{
            pisarz.writeObject(zmienna);
        }catch(Exception ex){ex.printStackTrace();}
    }
}