package dane;

import java.io.Serializable;

/**
 * Created by Marek on 15.06.2017.
 */
/**
 * <h2>Klasa przechowuje dane o potrzebne do wyświetlania histori.</h2>
 * <p>Posiada metody pozwalające operować danymi do wyświetlania histori.</p>
 */
public class Wiersz implements Serializable {
    private String rejestracja, marka, model, pojemnosc, moc, rok, paliwo, przebieg, spalanie, przeglad, wymianaOleju, wymianaRozrzadu, data;

    public Wiersz(String rejestracja, String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String przebieg, String spalanie, String przeglad, String wymianaOleju, String wymianaRozrzadu, String data) {
        this.rejestracja = rejestracja;
        this.marka = marka;
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
        this.rok = rok;
        this.paliwo = paliwo;
        this.przebieg = przebieg;
        this.spalanie = spalanie;
        this.przeglad = przeglad;
        this.wymianaOleju = wymianaOleju;
        this.wymianaRozrzadu = wymianaRozrzadu;
        this.data = data;
    }

    public String getRejestracaja() {
        return rejestracja;
    }
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public String getPojemnosc() {
        return pojemnosc;
    }
    public String getMoc() {
        return moc;
    }
    public String getRok() {
        return rok;
    }
    public String getPaliwo() {
        return paliwo;
    }
    public String getPrzebieg() {
        return przebieg;
    }
    public String getSpalanie() {
        return spalanie;
    }
    public String getPrzeglad() {
        return przeglad;
    }
    public String getWymianaOleju() {
        return wymianaOleju;
    }
    public String getWymianaRozrzadu() {
        return wymianaRozrzadu;
    }
    public String getData() {
        return data;
    }
    public String toString(){
        return rejestracja +" "+ marka +" "+ model +" "+ pojemnosc +" "+ moc +" "
                + rok +" "+ paliwo +" "+ przebieg +" "+ spalanie +" "+ przeglad +" "
                + wymianaOleju +" "+ wymianaRozrzadu +" "+ data;
    }
}
