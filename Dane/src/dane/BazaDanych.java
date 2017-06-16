package dane;

import java.util.ArrayList;

public class BazaDanych {
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
    public void add(DaneAuta dane){
        auto.add(dane);
    }
    public String getRejestracja(int i) {
        return auto.get(i).getRejestracja();
    }
}
