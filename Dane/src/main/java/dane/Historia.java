package dane;

import java.io.Serializable;

/**
 * Created by Marek on 12.06.2017.
 */

/**
 * <h2>Klasa przechowuje historie o samochodzie.</h2>
 * <p>Posiada metody pozwalające operować historią samochodu.</p>
 */
public class Historia implements Serializable {
    private String idHistoria, idRejestracja, przebieg, spalenie, przeglad, wymianaOleju, wymianaRozrzadu, data;

    public Historia(){}

    public Historia(String idHistoria, String idRejestracja, String przebieg, String spalenie, String przeglad, String wymianaOleju, String wymianaRozrzadu, String data) {
        this.idHistoria = idHistoria;
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.przeglad = przeglad;
        this.wymianaOleju = wymianaOleju;
        this.wymianaRozrzadu = wymianaRozrzadu;
        this.data = data;
    }

    public Historia(String przebieg, String spalenie, String przeglad, String wymianaOleju, String wymianaRozrzadu, String data) {
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.przeglad = przeglad;
        this.wymianaOleju = wymianaOleju;
        this.wymianaRozrzadu = wymianaRozrzadu;
        this.data = data;
    }

    public void dodaj(String idHistoria, String idRejestracja, String przebieg, String spalenie, String przeglad, String wymianaOleju, String wymianaRozrzadu, String data) {
        this.idHistoria = idHistoria;
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.przeglad = przeglad;
        this.wymianaOleju = wymianaOleju;
        this.wymianaRozrzadu = wymianaRozrzadu;
        this.data = data;
    }

    public void dodaj(String przebieg, String spalenie, String przeglad, String wymianaOleju, String wymianaRozrzadu, String data) {
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.przeglad = przeglad;
        this.wymianaOleju = wymianaOleju;
        this.wymianaRozrzadu = wymianaRozrzadu;
        this.data = data;
    }


    public String getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(String idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getIdRejestracja() {
        return idRejestracja;
    }

    public void setIdRejestracja(String idRejestracja) {
        this.idRejestracja = idRejestracja;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(String przebieg) {
        this.przebieg = przebieg;
    }

    public String getSpalanie() {
        return spalenie;
    }

    public void setSpalanie(String spalenie) {
        this.spalenie = spalenie;
    }

    public String getPrzeglad() {
        return przeglad;
    }

    public void setPrzeglad(String przeglad) {
        this.przeglad = przeglad;
    }

    public String getWymianaOleju() {
        return wymianaOleju;
    }

    public void setWymianaOleju(String wymianaOleju) {
        this.wymianaOleju = wymianaOleju;
    }

    public String getWymianaRozrzadu() {
        return wymianaRozrzadu;
    }

    public void setWymianaRozrzadu(String wymianaRozrzadu) {
        this.wymianaRozrzadu = wymianaRozrzadu;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Historia{" +
                "idHistoria='" + idHistoria + '\'' +
                ", idRejestracja='" + idRejestracja + '\'' +
                ", przebieg='" + przebieg + '\'' +
                ", spalenie='" + spalenie + '\'' +
                ", przeglad='" + przeglad + '\'' +
                ", wymianaOleju='" + wymianaOleju + '\'' +
                ", wymianaRozrzadu='" + wymianaRozrzadu + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
