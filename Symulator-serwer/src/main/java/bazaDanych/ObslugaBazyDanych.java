package bazaDanych;

import dane.*;
import org.apache.log4j.Logger;

import java.sql.*;

public class ObslugaBazyDanych {

    private final static Logger logger = Logger.getLogger(ObslugaBazyDanych.class);

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:projektjava@//localhost:1521/xe";
    String user = "projektjava";
    String password = "projektjava";
    Connection conection;
    Statement stmtRejestracja;
    Statement stmtSamochod;
    Statement stmtHistoria;

    public ObslugaBazyDanych()
    {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.error("Brak sterownika",e);
        }
        try {
            conection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error("Błędne dane logowania",e);
        }
        try {
            stmtRejestracja = conection.createStatement();
        } catch (SQLException e) {
            logger.error("Nie można nawiązać połączenia",e);
        }
        try {
            stmtSamochod = conection.createStatement();
        } catch (SQLException e) {
            logger.error("Nie można nawiązać połączenia",e);
        }
        try {
            stmtHistoria = conection.createStatement();
        } catch (SQLException e) {
            logger.error("Nie można nawiązać połączenia",e);
        }
    }

    public BazaDanych odczytSamochodu()
    {
        BazaDanych baza = new BazaDanych();
        ResultSet samochod = null;
        ResultSet rejestracja = null;
        try {
            rejestracja = stmtRejestracja.executeQuery("SELECT * FROM Rejestracja ORDER BY IdRejestracja");
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania do bazy",e);
        }
        try {
            while (rejestracja.next()) {
                try {
                    samochod = stmtSamochod.executeQuery("SELECT * FROM Samochod WHERE IdSamochod = " + rejestracja.getString(2));
                } catch (SQLException e) {
                    logger.error("Nie można wykonać podanego zapytania do bazy",e);
                }
                samochod.next();
                baza.add(new DaneAuta(rejestracja.getString(1), samochod.getString(1), samochod.getString(2),samochod.getString(3),samochod.getString(4),samochod.getString(5),samochod.getString(6), samochod.getString(7), rejestracja.getString(3)));
            }
        } catch (SQLException e) {
            logger.error("Nie można pobrać danych z bazy",e);
        }
        return baza;
    }

    public BazaHistoria odczytHistori()
    {
        BazaHistoria baza = new BazaHistoria();
        ResultSet historia = null;
        try {
            historia = stmtHistoria.executeQuery("SELECT * FROM Historia");
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania do bazy",e);
        }
        try {
            while (historia.next())
            {
                baza.add(new Historia(historia.getString(1), historia.getString(2),historia.getString(3),historia.getString(4),historia.getString(5),historia.getString(6),historia.getString(6),historia.getString(8)));
            }
        } catch (SQLException e) {
            logger.error("Nie można pobrać danych z bazy",e);
        }
        return baza;
    }

    public void zapisSamochodu(DaneAuta dane)
    {
        String samochod = "INSERT INTO Samochod VALUES('" + dane.getIdSamochod() + "','" + dane.getMarka() + "','" + dane.getModel() + "','" + dane.getPojemnosc() + "','" + dane.getMoc() + "','" + dane.getRok() + "','" + dane.getPaliwo() + "')";
        System.out.println(samochod);
        try {
            stmtSamochod.executeUpdate(samochod);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
        }
    }

    public void zapisRejestracji(DaneAuta dane)
    {
        String rejestracja = "INSERT INTO Rejestracja VALUES('" + dane.getIdRejestracja() + "','" + dane.getIdSamochod() + "','" + dane.getRejestracja() + "')";
        System.out.println(rejestracja);
        try {
            stmtRejestracja.executeUpdate(rejestracja);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
        }
    }

    public void zapisHistoria(Historia dane)
    {
        String historia = "INSERT INTO Historia VALUES('" + dane.getIdHistoria() + "','" + dane.getIdRejestracja() + "','" + dane.getPrzebieg() + "','" + dane.getSpalenie() + "','" + dane.getPrzeglad() + "','" + dane.getWymianaOleju() + "','" + dane.getWymianaRozrzadu() + "','" + dane.getData() + "')";
        System.out.println(historia);
        try {
            stmtHistoria.executeUpdate(historia);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
        }
    }

    public void usunRejestracje(String idRejestracji)
    {
        String rejestracja = "DELETE FROM Rejestracja WHERE IdRejestracja = " + idRejestracji;
        try {
            stmtRejestracja.executeUpdate(rejestracja);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
        }
    }

    public void usunHistorie(String idRejestracji)
    {
        String historia = "DELETE FROM Historia WHERE IdRejestracja = " + idRejestracji;
        try {
            stmtHistoria.executeUpdate(historia);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
        }
    }

    public boolean szukajAuta(DaneAuta autoSzukane, BazaDanych baza)
    {
       String rej = autoSzukane.getRejestracja();
       autoSzukane.setRejestracja(null);
        for(int i = 0; i < baza.size(); i++){
            if(baza.getNieObject(i).equals(autoSzukane)){
                autoSzukane.setRejestracja(rej);
                autoSzukane.setIdSamochod(baza.getIdSamochodu(i));
                return true;
            }
        }
        Integer max = 1;
        for (int i = 0; i < baza.size(); i++) {
            if (max <= Integer.valueOf(baza.getIdSamochodu(i))) {
                max = Integer.valueOf(baza.getIdSamochodu(i)) + 2;
            }
        }
        autoSzukane.setIdSamochod(max.toString());
        autoSzukane.setRejestracja(rej);
        return false;
    }


}
