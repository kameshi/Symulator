package javaPackage.dane;

/**
 * Created by Marek on 12.06.2017.
 */
public class Historia {
    String idHistoria, idRejestracja, przebieg, spalenie, data;

    public Historia(){}

    public Historia(String idHistoria, String idRejestracja, String przebieg, String spalenie, String data) {
        this.idHistoria = idHistoria;
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.data = data;
    }

    public Historia(String idRejestracja, String przebieg, String spalenie, String data) {
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.data = data;
    }

    public Historia(String idRejestracja, String przebieg, String data) {
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.data = data;
        this.spalenie = "0";
    }

    public void dodaj(String idHistoria, String idRejestracja, String przebieg, String spalenie, String data) {
        this.idHistoria = idHistoria;
        this.idRejestracja = idRejestracja;
        this.przebieg = przebieg;
        this.spalenie = spalenie;
        this.data = data;
    }

    public String getIdHistoria() {
        return idHistoria;
    }
    public String getIdRejestracja() {
        return idRejestracja;
    }
    public String getPrzebieg() {
        return przebieg;
    }
    public String getSpalenie() {
        return spalenie;
    }
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Historia{" +
                "idHistoria='" + idHistoria + '\'' +
                ", idRejestracja='" + idRejestracja + '\'' +
                ", przebieg='" + przebieg + '\'' +
                ", spalenie='" + spalenie + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
