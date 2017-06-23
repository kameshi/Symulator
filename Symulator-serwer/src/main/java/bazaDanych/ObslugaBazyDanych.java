package bazaDanych;

import dane.*;
import org.apache.log4j.Logger;

import java.sql.*;

public class ObslugaBazyDanych {

    private final static Logger logger = Logger.getLogger(ObslugaBazyDanych.class);

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:projektjava@//localhost:1521/xe";
    private String user = "projektjava";
    private String password = "projektjava";
    private Connection conection;
    private Statement stmt;
    private Statement stmt2;

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
            stmt = conection.createStatement();
        } catch (SQLException e) {
            logger.error("Nie można nawiązać połączenia",e);
        }
        try {
            stmt2 = conection.createStatement();
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
            rejestracja = stmt.executeQuery("SELECT * FROM Rejestracja ORDER BY IdRejestracja");
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania do bazy",e);
        }
        try {
            while (rejestracja.next()) {
                try {
                    samochod = stmt2.executeQuery("SELECT * FROM Samochod WHERE IdSamochod = " + rejestracja.getString(2));
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
            historia = stmt.executeQuery("SELECT * FROM Historia");
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

    public boolean zapis( String tabela, String dane)
    {
        String zapytanie = "INSERT INTO " + tabela + " VALUES(" + dane + ")";
        System.out.println(zapytanie);
        try {
            stmt.executeUpdate(zapytanie);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
            return false;
        }
        return true;
    }

    public boolean usun(String tabela, String warunek)
    {
        String rejestracja = "DELETE FROM " + tabela + " WHERE " + warunek;
        System.out.println(rejestracja);
        try {
            stmt.executeUpdate(rejestracja);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania na bazie",e);
            return false;
        }
        return true;
    }

    public void zakonczPolaczenie(){
        try {
            conection.close();
            logger.error("Połączenie z bazą zakończone.");
        } catch (SQLException e) {
            logger.error("Nie można zakończyć połączeniaz bazą.",e);
        }
        try {
            stmt.close();
            logger.error("Połączenie z bazą zakończone.");
        } catch (SQLException e) {
            logger.error("Nie można zakończyć połączeniaz bazą.",e);
        }
        try {
            stmt2.close();
            logger.error("Połączenie z bazą zakończone.");
        } catch (SQLException e) {
            logger.error("Nie można zakończyć połączeniaz bazą.",e);
        }
    }

    public int maxId(String kolumna, String tabela)
    {
        ResultSet zapytanie = null;
        try {
            zapytanie = stmt.executeQuery("SELECT MAX(" + kolumna + ") FROM " + tabela);
        } catch (SQLException e) {
            logger.error("Nie można wykonać podanego zapytania do bazy",e);
            return 0;
        }
        try {
            zapytanie.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        try {
            return  zapytanie.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
