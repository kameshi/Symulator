import bazaDanych.ObslugaBazyDanych;
import dane.DaneAuta;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Marek on 23.06.2017.
 */
public class TestObslugaBazyDanych {

    private ObslugaBazyDanych obslugaBazyDanych;
    private DaneAuta daneAuta;
    private String maxId;

    @Before
    public void setUp()
    {
        obslugaBazyDanych = new ObslugaBazyDanych();
        maxId = Integer.toString(obslugaBazyDanych.maxId("IdHistoria","Historia"));
        daneAuta = new DaneAuta(Integer.toString(obslugaBazyDanych.maxId("IdRejestracja","Rejestracja")), Integer.toString(obslugaBazyDanych.maxId("IdSamochod","Samochod")+1),"marka","model","1400","43","1960","benzyna","tsa 42fsh");
    }

    @Test
    public void zapis()
    {
        obslugaBazyDanych.zapis("brakTabeli","błedne dane");
        obslugaBazyDanych.zapis("Samochod", "błedne dane");
        obslugaBazyDanych.zapis("brakTabeli","'" + daneAuta.getIdSamochod() + "','" + daneAuta.getMarka() + "','" + daneAuta.getModel() + "','" + daneAuta.getPojemnosc() + "','" + daneAuta.getMoc() + "','" + daneAuta.getRok() + "','" + daneAuta.getPaliwo() + "'");
        obslugaBazyDanych.zapis("Rejestracja","'" + daneAuta.getIdSamochod() + "','" + daneAuta.getMarka() + "','" + daneAuta.getModel() + "','" + daneAuta.getPojemnosc() + "','" + daneAuta.getMoc() + "','" + daneAuta.getRok() + "','" + daneAuta.getPaliwo() + "'");
        obslugaBazyDanych.zapis("Samochod","'" + daneAuta.getIdSamochod() + "','" + daneAuta.getMarka() + "','" + daneAuta.getModel() + "','" + daneAuta.getPojemnosc() + "','" + daneAuta.getMoc() + "','" + daneAuta.getRok() + "','" + daneAuta.getPaliwo() + "'");
    }

    @Test
    public void usun()
    {
        obslugaBazyDanych.usun("brakTabeli","błedny warunek");
        obslugaBazyDanych.usun("Samochod", "błedny warunek");
        obslugaBazyDanych.usun("brakTabeli","maxId");
        obslugaBazyDanych.usun("Rejestracja","maxId");
        obslugaBazyDanych.usun("Historia","IdHistoria =" + maxId);
    }
}
