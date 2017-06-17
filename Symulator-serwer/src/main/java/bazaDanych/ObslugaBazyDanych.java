package bazaDanych;

import com.sun.org.apache.bcel.internal.generic.Select;
import dane.*;

import java.sql.*;

public class ObslugaBazyDanych {

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:projektjava@//localhost:1521/xe";
    String user = "projektjava";
    String password = "projektjava";
    Connection conection;
    Statement stmtRejestracja;
    Statement stmtSamochod;
    Statement stmtHistoria;

    public ObslugaBazyDanych() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conection = DriverManager.getConnection(url, user, password);
        stmtRejestracja = conection.createStatement();
        stmtSamochod = conection.createStatement();
        stmtHistoria = conection.createStatement();
    }

    public BazaDanych odczytSamochodu() throws SQLException {
        BazaDanych baza = new BazaDanych();
        ResultSet samochod ;
        ResultSet rejestracja = stmtRejestracja.executeQuery("SELECT * FROM Rejestracja ORDER BY IdRejestracja");
        DaneAuta dane = new DaneAuta();
        while (rejestracja.next()) {
            samochod = stmtSamochod.executeQuery("SELECT * FROM Samochod WHERE IdSamochod = " + rejestracja.getString(2));
            samochod.next();
            dane.dodaj(rejestracja.getString(1), samochod.getString(1), samochod.getString(2),samochod.getString(3),samochod.getString(4),samochod.getString(5),samochod.getString(6), samochod.getString(7), rejestracja.getString(3));
            baza.add(dane);
            //System.out.println(dane.toString());
        }
        return baza;
    }

    public BazaHistoria odczytHistori() throws SQLException
    {
        BazaHistoria baza = new BazaHistoria();
        ResultSet historia = stmtHistoria.executeQuery("SELECT * FROM Historia");
        Historia dane = new Historia();
        while (historia.next())
        {
            dane.dodaj(historia.getString(1), historia.getString(2),historia.getString(3),historia.getString(4),historia.getString(5),historia.getString(6),historia.getString(6),historia.getString(8));
            baza.add(dane);
            //System.out.println(dane.toString());
        }
        return baza;
    }

    public void zapisSamochodu(DaneAuta dane) throws SQLException {
        String samochod = "INSERT INTO Samochod VALUES('" + dane.getIdSamochod() + "','" + dane.getMarka() + "','" + dane.getModel() + "','" + dane.getPojemnosc() + "','" + dane.getMoc() + "','" + dane.getRok() + "','" + dane.getPaliwo() + "')";
        System.out.println(samochod);
        stmtSamochod.executeUpdate(samochod);
    }

    public void zapisRejestracji(DaneAuta dane) throws SQLException {
        String rejestracja = "INSERT INTO Rejestracja VALUES('" + dane.getIdRejestracja() + "','" + dane.getIdSamochod() + "','" + dane.getRejestracja() + "')";
        System.out.println(rejestracja);
        stmtRejestracja.executeUpdate(rejestracja);
    }

    public void zapisHistoria(Historia dane) throws SQLException {
        String historia = "INSERT INTO Historia VALUES('" + dane.getIdHistoria() + "','" + dane.getIdRejestracja() + "','" + dane.getPrzebieg() + "','" + dane.getSpalenie() + "','" + dane.getPrzeglad() + "','" + dane.getWymianaOleju() + "','" + dane.getWymianaRozrzadu() + "','" + dane.getData() + "')";
        System.out.println(historia);
        stmtHistoria.executeUpdate(historia);
    }

    public void usunRejestracje(String idRejestracji) throws SQLException {
        String rejestracja = "DELETE FROM Rejestracja WHERE IdRejestracja = " + idRejestracji;
        stmtRejestracja.executeUpdate(rejestracja);
    }

    public void usunHistorie(String idRejestracji) throws SQLException {
        String historia = "DELETE FROM Historia WHERE IdRejestracja = " + idRejestracji;
        stmtHistoria.executeUpdate(historia);
    }


}
