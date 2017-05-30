package javaPackage.dane;

/**
 * Created by Marek on 25.05.2017.
 */
public class Model {
    private int idModel, idMarka;
    private String nazwa;

    public Model(int idModel, int idMarka, String nazwa) {
        this.idModel = idModel;
        this.idMarka = idMarka;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Model{" +
                "idModel=" + idModel +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    public int getIdMarka() {
        return idMarka;
    }

    public int getIdModel() {
        return idModel;
    }

    public String getNazwa() {
        return nazwa;
    }
}
