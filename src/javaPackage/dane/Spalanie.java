package javaPackage.dane;

/**
 * Created by Marek on 25.05.2017.
 */
public class Spalanie {
    int idSpalanie, idSamochod;
    String srPredkosc, srSpalanie;

    public Spalanie(int idSpalanie, int idSamochod, String srPredkosc, String srSpalanie) {
        this.idSpalanie = idSpalanie;
        this.idSamochod = idSamochod;
        this.srPredkosc = srPredkosc;
        this.srSpalanie = srSpalanie;
    }

    @Override
    public String toString() {
        return "Spalanie{" +
                "idSpalanie=" + idSpalanie +
                ", idSamochod=" + idSamochod +
                ", srPredkosc='" + srPredkosc + '\'' +
                ", srSpalanie='" + srSpalanie + '\'' +
                '}';
    }

    public int getIdSpalanie() {
        return idSpalanie;
    }

    public int getIdSamochod() {
        return idSamochod;
    }

    public String getSrPredkosc() {
        return srPredkosc;
    }

    public String getSrSpalanie() {
        return srSpalanie;
    }
}
