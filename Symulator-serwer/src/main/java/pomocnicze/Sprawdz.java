package pomocnicze;

import bazaDanych.ObslugaBazyDanych;
import dane.BazaDanych;
import dane.BazaHistoria;
import dane.DaneAuta;

/**
 * Created by Marek on 23.06.2017.
 */
public class Sprawdz {
    public boolean szukajAuta(DaneAuta autoSzukane, BazaDanych baza)
    {
        String rej = autoSzukane.getRejestracja();
        for(int i = 0; i < baza.size(); i++){
            if(baza.getMarka(i).equals(autoSzukane.getMarka()) && baza.getMoc(i).equals(autoSzukane.getMoc())){
                if(baza.getModel(i).equals(autoSzukane.getModel()) && baza.getRok(i).equals(autoSzukane.getRok())){
                    if(baza.getPojemnosc(i).equals(autoSzukane.getPojemnosc()) && baza.getPaliwo(i).equals(autoSzukane.getPaliwo())){
                        autoSzukane.setRejestracja(rej);
                        autoSzukane.setIdSamochod(baza.getIdSamochodu(i));
                        return true;
                    }
                }
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
    public boolean szukajAuta(String[] dane, BazaDanych baza, BazaHistoria historia){
        ObslugaBazyDanych obslugaBazyDanych = new ObslugaBazyDanych();
        String idRej = null;
        boolean kontrol = false;
        for(int i = 0; i < baza.size(); i++) {
            if (baza.getRejestracja(i).equals(dane[0])){// || baza.getMarka(i).equals(dane[1]) && baza.getModel(i).equals(dane[2])) {
                idRej = baza.getRejestracja(i);
                kontrol = true;
            }
        }
        if(kontrol){
            for(int i = 0; i < historia.size(); i++){
                if(idRej.equals(historia.getIdRejestracja(i))){
                    obslugaBazyDanych.usun("Historia","IdRejestracja = " + idRej);
                }
            }
            obslugaBazyDanych.usun("Rejestracja","idRejestracja = " + idRej);
            return kontrol;
        }
        return kontrol;
    }

}
