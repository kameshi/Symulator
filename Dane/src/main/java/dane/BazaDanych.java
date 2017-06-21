package dane;

import java.io.Serializable;
import java.util.ArrayList;

public class BazaDanych implements Serializable {
    private ArrayList<DaneAuta> auto = new ArrayList<DaneAuta>();
    public BazaDanych(){}
    public BazaDanych(String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String rejestracja){
        auto.add(new DaneAuta( marka, model, pojemnosc, moc, rok, paliwo, rejestracja));
    }
    public int size(){
        return auto.size();
    }
    public DaneAuta getObject(int i){
        return auto.get(i);
    }
    public DaneAuta getNieObject(int i){
        DaneAuta dane = new DaneAuta();
        dane.dodaj(auto.get(i).getMarka(), auto.get(i).getModel(), auto.get(i).getPojemnosc(), auto.get(i).getMoc(), auto.get(i).getRok(), auto.get(i).getPaliwo(), null);
        return dane;
    }
    public void add(DaneAuta dane){
        auto.add(dane);
    }
    public String getRejestracja(int i) {
        return auto.get(i).getRejestracja();
    }
    public String getIdRejestracja(int i) {
        return auto.get(i).getIdRejestracja();
    }
    public String getIdSamochodu(int i) {
        return auto.get(i).getIdSamochod();
    }
}
