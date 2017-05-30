package javaPackage.dane;

/**
 * Created by Marek on 25.05.2017.
 */
public class Marka {
    private int idMarka;
    private String nazwa;

    public Marka(int idMarka, String nazwa)
    {
        this.idMarka = idMarka;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Marka{" +
                "idMarka=" + idMarka +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    public int getIdMarka()
    {
        return idMarka;
    }

    public String getNazwa()
    {
        return nazwa;
    }
}
