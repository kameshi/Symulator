import dane.BazaDanych;
import dane.BazaHistoria;
import dane.DaneAuta;
import dane.Historia;
import org.junit.Before;
import org.junit.Test;
import pomocnicze.Sprawdz;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marek on 24.06.2017.
 */
public class TestSprawdz {
    private Sprawdz sprawdz;
    private DaneAuta daneAuta;
    private DaneAuta daneAuta3;
    private BazaDanych bazaDanych;
    private BazaHistoria bazaHistoria;
    private String[] dane;
    private String[] dane2;

    @Before
    public void setUp()
    {
        sprawdz = new Sprawdz();
        daneAuta3 = new DaneAuta("4", "5","marka3","model3","1200","43","1960","benzyna","tsa 42fsh");
        bazaDanych = new BazaDanych();
        bazaDanych.add(daneAuta);
        bazaDanych.add(new DaneAuta("2", "3","marka2","model2","1454","67","1967","gaz","tsa gfdb"));
        bazaHistoria = new BazaHistoria();
        bazaHistoria.add(new Historia("1","1","140000","10,3","tak","nie","nie","tak"));
        bazaHistoria.add(new Historia("1","1","140000","10,3","tak","nie","nie","tak"));
        dane = new String[]{"1", "marka", "model"};
        dane2 = new String[]{"6", "marka6", "model6"};
    }

    @Test
    public void szukajAuta1()
    {
        assertTrue(sprawdz.szukajAuta(daneAuta3,bazaDanych));
        assertTrue(sprawdz.szukajAuta(daneAuta,bazaDanych));
    }

    @Test
    public void szukajAuta2()
    {
        assertTrue(sprawdz.szukajAuta(dane2,bazaDanych,bazaHistoria));
        assertTrue(sprawdz.szukajAuta(dane,bazaDanych,bazaHistoria));
    }
}
