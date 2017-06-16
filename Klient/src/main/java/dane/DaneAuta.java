package dane;

public class DaneAuta {
    String idRejestracja, idSamochod, marka, model, pojemnosc, moc, rok, paliwo, rejestracja;

    public DaneAuta(){}

    public DaneAuta(String idRejestracja, String idSamochod, String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String rejestracja) {
        this.idRejestracja = idRejestracja;
        this.idSamochod = idSamochod;
        this.marka = marka;
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
        this.rok = rok;
        this.paliwo = paliwo;
        this.rejestracja = rejestracja;
    }

    public DaneAuta(String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String rejestracja) {
        this.marka = marka;
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
        this.rok = rok;
        this.paliwo = paliwo;
        this.rejestracja = rejestracja;
    }

    public void dodaj(String idRejestracja, String idSamochod, String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String rejestracja) {
        this.idRejestracja = idRejestracja;
        this.idSamochod = idSamochod;
        this.marka = marka;
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
        this.rok = rok;
        this.paliwo = paliwo;
        this.rejestracja = rejestracja;
    }

    public void dodaj(String marka, String model, String pojemnosc, String moc, String rok, String paliwo, String rejestracja) {
        this.marka = marka;
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
        this.rok = rok;
        this.paliwo = paliwo;
        this.rejestracja = rejestracja;
    }

    @Override
    public String toString() {
        return "DaneAuta{" +
                "idRejestracja='" + idRejestracja + '\'' +
                ", idSamochod='" + idSamochod + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", pojemnosc='" + pojemnosc + '\'' +
                ", moc='" + moc + '\'' +
                ", rok='" + rok + '\'' +
                ", paliwo='" + paliwo + '\'' +
                ", rejestracja='" + rejestracja + '\'' +
                '}';
    }

    public String getIdRejestracja() {
        return idRejestracja;
    }
    public String getIdSamochod() {
        return idSamochod;
    }
    public String getMarka(){
        return marka;
    }
    public String getModel(){
        return model;
    }
    public String getPojemnosc(){
        return pojemnosc;
    }
    public String getMoc(){
        return moc;
    }
    public String getRok(){
        return rok;
    }
    public String getPaliwo() {
        return paliwo;
    }
    public String getRejestracja() {
        return rejestracja;
    }

    public void setIdRejestracja(String idRejestracja) {
        this.idRejestracja = idRejestracja;
    }
    public void setIdSamochod(String idSamochod) {
        this.idSamochod = idSamochod;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setPojemnosc(String pojemnosc) {
        this.pojemnosc = pojemnosc;
    }
    public void setMoc(String moc) {
        this.moc = moc;
    }
    public void setRok(String rok) {
        this.rok = rok;
    }
    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }
    public void setRejestracja(String rejestracja) {
        this.rejestracja = rejestracja;
    }
}
