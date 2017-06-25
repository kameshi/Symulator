package komunikacja;

import bazaDanych.ObslugaBazyDanych;
import dane.*;
import org.apache.log4j.Logger;
import pomocnicze.Sprawdz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h2>Klasa odpowiedzialna za komunikacje z klientem.</h2>
 * <p>Posiada metody komunikujace sie z klientem. Działa na bazie watków pojedynczego połaczenia</p>
 */

public class Komunikacja implements Runnable{

    private final static Logger logger = Logger.getLogger(Komunikacja.class);
    private static int inte = 4;
    private Sprawdz sprawdz;
    private BazaHistoria bazaHistoria;
    private BazaDanych baza;
    private ObslugaBazyDanych obslugaBazy;
    private int Port;
    private Socket gniazdoKlienta;
    private ObjectOutputStream pisarz;
    private ObjectInputStream czytelnik;
    private String host;

    /**
     * Metoda odpowiadająca za zarejestrowanie połaczenia.
     * @param port port na jakiem server jest aktywny
     * @param host lokalny host na jakim działa server
     * @param gniazdoKlienta gniazdo na jakim server odbiera
     */
    public Komunikacja(int port, String host, Socket gniazdoKlienta) {
        sprawdz = new Sprawdz();
        bazaHistoria = new BazaHistoria();
        baza = new BazaDanych();
        obslugaBazy = new ObslugaBazyDanych();

        this.Port = port;
        this.host = host;
        this.gniazdoKlienta = gniazdoKlienta;
    }
    /**
     * Metoda odpowiadająca za dzialanie pojedynczego połaczenia z klientem.
     */
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
                }else if(semafor.equals("sort")){
                    histroiaSort();
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
    /**
     * Metoda odpowiadająca za obsługę działania w przypadku aktualizacji danych w bazie.
     */
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
            obslugaBazy.zapis("Historia", "'" + historia.getIdHistoria() + "','" + historia.getIdRejestracja() + "','" + historia.getPrzebieg() + "','" + historia.getSpalanie() + "','" + historia.getPrzeglad() + "','" + historia.getWymianaOleju() + "','" + historia.getWymianaRozrzadu() + "','" + historia.getData() + "'");
        }
        rozeslanie(kontrol);
    }
    /**
     * Metoda odpowiadająca za obsługę działania w przypadku dodania danych do bazy.
     */
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
        Integer max = 1;
        for (int i = 0; i < baza.size(); i++) {
            if (baza.getRejestracja(i).equals(auto.getRejestracja())) {
                kontrol = false;
                break;
            }
        }
        if(kontrol) {
            max = obslugaBazy.maxId("IdRejestracja", "Rejestracja") + 1;
            if (sprawdz.szukajAuta(auto, baza)) {
                auto.setIdRejestracja(max.toString());
                obslugaBazy.zapis("Rejestracja", "'" + auto.getIdRejestracja() + "','" + auto.getIdSamochod() + "','" + auto.getRejestracja() + "'");
                kontrol = false;
            }
            if (kontrol) {
                auto.setIdRejestracja(max.toString());
                obslugaBazy.zapis("Samochod", "'" + auto.getIdSamochod() + "','" + auto.getMarka() + "','" + auto.getModel() + "','" + auto.getPojemnosc() + "','" + auto.getMoc() + "','" + auto.getRok() + "','" + auto.getPaliwo() + "'");
                obslugaBazy.zapis("Rejestracja", "'" + auto.getIdRejestracja() + "','" + auto.getIdSamochod() + "','" + auto.getRejestracja() + "'");
            }
        }
        rozeslanie(kontrol);
    }
    /**
     * Metoda odpowiadająca za obsługę działania w przypadku odbioru historii z bazy danych.
     */
    private void historia(){
        boolean kontrol = true;
        if(bazaHistoria.size() < 0){
            kontrol = false;
        }else {
            bazaHistoria = obslugaBazy.odczytHistori();
            baza = obslugaBazy.odczytSamochodu();
            BazaWiersz bazaWiersz = new BazaWiersz();
            wierszowanie(bazaWiersz, baza, bazaHistoria);
            rozeslanie(bazaWiersz);
        }
        rozeslanie(kontrol);
    }
    /**
     * Metoda odpowiadająca za obsługę działania w przypadku odbioru historii posortowanej bazy danych.
     */
    private void histroiaSort(){
        boolean kontrol = true;
        if(bazaHistoria.size() < 0){
            kontrol = false;
        }else {
            String rejestracja = null;
            try {
                rejestracja = (String) czytelnik.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            bazaHistoria = obslugaBazy.odczytHistori();
            baza = obslugaBazy.odczytSamochodu();
            BazaWiersz bazaWiersz = new BazaWiersz();
            wierszowanie(bazaWiersz, baza, bazaHistoria, rejestracja);
            rozeslanie(bazaWiersz);
        }
    }
    /**
     * Metoda odpowiadająca za obsługę działania w przypadku usuwania rekordu z bazy danych.
     */
    private void usun(){
        String[] dane = new String[3];
        String idRej = null;
        boolean kontrol = false;
        for(int i = 0; i < 3; i++){
            try {
                dane[i] = (String) czytelnik.readObject();
            } catch (IOException e) {
                logger.error("Brak sterownika",e);
            } catch (ClassNotFoundException e) {
                logger.error("Brak sterownika",e);
            }
        }
        baza = obslugaBazy.odczytSamochodu();
        for(int i = 0; i < baza.size(); i++) {
            if (baza.getRejestracja(i).equals(dane[0]) && baza.getMarka(i).equals(dane[1]) && baza.getModel(i).equals(dane[2])) {
                idRej = baza.getIdRejestracja(i);
                kontrol = true;
            }
        }
        bazaHistoria = obslugaBazy.odczytHistori();
        if(kontrol){
            for(int i = 0; i < bazaHistoria.size(); i++){
                if(idRej.equals(bazaHistoria.getIdRejestracja(i))){
                    obslugaBazy.usun("Historia","IdRejestracja = " + idRej);
                }
            }
            obslugaBazy.usun("Rejestracja","IdRejestracja = " + idRej);
        }
        rozeslanie(kontrol);
    }
    /**
     * Metoda odpowiadająca za wysłanie bazy wierszy.
     * * @param baza baza rozwyłana na klienta
     */
    private void rozeslanie(BazaWiersz baza){
        try{
            pisarz.writeObject(baza);
        }catch(Exception ex){ex.printStackTrace();}
    }
    /**
     * Metoda odpowiadająca za wysłanie kontrolenj liczby.
     * * @param zmienna wysyłanie kontrolnej liczby na klient.
     */
    private void rozeslanie(boolean zmienna){
        try{
            pisarz.writeObject(zmienna);
        }catch(Exception ex){ex.printStackTrace();}
    }
    /**
     * Metoda odpowiadająca za wysłanie bazy wierszy.
     * * @param  bazaWiersz baza przygotowywana do wysłania
     * * @param baza baza z której czerpie dane
     * * @param baza bazaHistoria z której czerpie dane
     */
    private void wierszowanie(BazaWiersz bazaWiersz, BazaDanych baza, BazaHistoria bazaHistoria){
        for(int i = 0; i < baza.size(); i++){
            for(int j = 0; j < bazaHistoria.size(); j++){
                if(baza.getIdRejestracja(i).equals(bazaHistoria.getIdRejestracja(j))){
                    Wiersz dane = new Wiersz(baza.getRejestracja(i), baza.getMarka(i),
                            baza.getModel(i), baza.getPojemnosc(i),
                            baza.getMoc(i), baza.getRok(i),
                            baza.getPaliwo(i), bazaHistoria.getPrzebieg(j),
                            bazaHistoria.getSpalanie(j), bazaHistoria.getPrzeglad(j),
                            bazaHistoria.getWymianaOleju(j), bazaHistoria.getWymianaRozrzadu(j), bazaHistoria.getData(j));
                    bazaWiersz.add(dane);
                }
            }
        }
    }
    /**
     * Metoda odpowiadająca za wysłanie bazy wierszy.
     * * @param  bazaWiersz baza przygotowywana do wysłania
     * * @param baza baza z której czerpie dane
     * * @param baza bazaHistoria z której czerpie dane
     * * * @param napis rejestracja z której konrstrujemy baze wierszy.
     */
    private void wierszowanie(BazaWiersz bazaWiersz, BazaDanych baza, BazaHistoria bazaHistoria, String napis){
        for(int i = 0; i < baza.size(); i++){
            for(int j = 0; j < bazaHistoria.size(); j++){
                if(baza.getIdRejestracja(i).equals(bazaHistoria.getIdRejestracja(j))){
                    if(napis.equals(baza.getRejestracja(i))) {
                        Wiersz dane = new Wiersz(baza.getRejestracja(i), baza.getMarka(i),
                                baza.getModel(i), baza.getPojemnosc(i),
                                baza.getMoc(i), baza.getRok(i),
                                baza.getPaliwo(i), bazaHistoria.getPrzebieg(j),
                                bazaHistoria.getSpalanie(j), bazaHistoria.getPrzeglad(j),
                                bazaHistoria.getWymianaOleju(j), bazaHistoria.getWymianaRozrzadu(j), bazaHistoria.getData(j));
                        bazaWiersz.add(dane);
                    }
                }
            }
        }
    }
}