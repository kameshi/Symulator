package komunikacja;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.sql.SQLException;

import bazaDanych.ObslugaBazyDanych;
import dane.*;



public class Komunikacja implements Runnable{
    BazaHistoria bazaHistoria = new BazaHistoria();
    BazaDanych baza = new BazaDanych();
    ObslugaBazyDanych obslugaBazy = new ObslugaBazyDanych();
    private int Port;
    private Socket gniazdoKlienta;
    private ObjectOutputStream pisarz;
    private ObjectInputStream czytelnik;
    private String host;

    public Komunikacja(int port, String host, Socket gniazdoKlienta) throws SQLException, ClassNotFoundException {
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
                ex.printStackTrace();
            }
            pisarz.close();
            czytelnik.close();
            gniazdoKlienta.close();
        }
        catch (Exception e) {
            System.out.println("Wyjatek serwera " + e);
        }
    }
    private void stareAuto() throws SQLException, ClassNotFoundException, IOException {
        boolean kontrol = false;
        String nrRejestracyjny;
        Historia historia;
        nrRejestracyjny = (String) czytelnik.readObject();
        historia = (Historia) czytelnik.readObject();
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
    private void noweAuto() throws IOException, SQLException, ClassNotFoundException {
        DaneAuta auto;
        auto =(DaneAuta) czytelnik.readObject();
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
            obslugaBazy.zapisSamochodu(auto);
            obslugaBazy.zapisRejestracji(auto);
        }
        rozeslanie(kontrol);
    }
    private void historia() throws SQLException {
        boolean kontrol = true;
        if(bazaHistoria.size() < 0){
            kontrol = false;
        }else {
            bazaHistoria = obslugaBazy.odczytHistori();
            rozeslanie(bazaHistoria);
        }
        rozeslanie(kontrol);
    }
    private void usun() throws IOException, ClassNotFoundException {
        String[] dane = new String[3];
        for(int i = 0; i < 3; i++){
            dane[i] = (String) czytelnik.readObject();
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