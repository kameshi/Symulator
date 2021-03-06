package dane;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h2>Klasa przechowuje listę obiektów typu DaneAuta.</h2>
 * <p>Posiada metody pozwalające operować na liscie typu ArrayList zawierającej obiekty typu DaneAuta .</p>
 */
public class BazaDanych implements Serializable {
    private ArrayList<DaneAuta> auto = new ArrayList<>();
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
    public String getIdRejestracja(int i) {
        return auto.get(i).getIdRejestracja();
    }
    public String getIdSamochodu(int i) {
        return auto.get(i).getIdSamochod();
    }
    public String getMarka(int i) {return auto.get(i).getMarka();}
    public String getModel(int i) {
        return auto.get(i).getModel();
    }
    public String getMoc(int i) {
        return auto.get(i).getMoc();
    }
    public String getPojemnosc(int i) {
        return auto.get(i).getPojemnosc();
    }
    public String getRok(int i) {
        return auto.get(i).getRok();
    }
    public String getPaliwo(int i) {
        return auto.get(i).getPaliwo();
    }
}
