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
    private ServerSocket gniazdoSerwer;
    private Socket gniazdoKlienta;
    private ObjectOutputStream pisarz;
    private ObjectInputStream czytelnik;
    private String host;

    public Komunikacja(int port, String host) throws SQLException, ClassNotFoundException {
        Port = port;
        host = host;
        try{
            gniazdoSerwer = new ServerSocket(Port);
        }catch(IOException e) {
            System.out.println(e);
        }
    }

    public void run() {
        System.out.println("Serwer startuje na hoscie " + host);
        try {
            try {
                gniazdoKlienta = gniazdoSerwer.accept();
            } catch (IOException e) {
                System.out.println("Nie moz na polaczyc sie z klientem " + e);
                System.exit(1);
            }
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
        System.out.println(baza.getRejestracja(1));
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
        System.out.println("nowe");
        DaneAuta auto;
        auto =(DaneAuta) czytelnik.readObject();
        Boolean kontrol = true;
        baza = obslugaBazy.odczytSamochodu();
        Integer max = 1;
        System.out.println("2");
        for(int i=0; i <baza.size(); i++){
            if(max < Integer.valueOf(baza.getIdRejestracja(i))){
                max = Integer.valueOf(baza.getIdRejestracja(i));
            }
        }
        System.out.println(max);
        if (obslugaBazy.szukajAuta(auto , baza)) {
            auto.setIdRejestracja(max.toString());
            obslugaBazy.zapisSamochodu(auto);
            kontrol = false;
        }
        if(kontrol){
            auto.setIdRejestracja(max.toString());
            obslugaBazy.zapisSamochodu(auto);
        }
        System.out.println(auto.toString());
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
        pisarz.writeObject("usun");
        String g = (String) czytelnik.readObject();
        System.out.println(g);
        g = (String) czytelnik.readObject();
        System.out.println(g);
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