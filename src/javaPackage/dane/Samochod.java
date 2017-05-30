package javaPackage.dane;

public class Samochod {
	private int idSamochod, idModel;
	private String moc, rokProdukcji, rodzajPaliwa, pojemnosc;
	
	public Samochod(int idSamochod, int idModel, String moc, String rokProdukcji, String rodzajPaliwa, String pojemnosc){
		this.idSamochod = idSamochod;
		this.idModel = idModel;
		this.moc = moc;
		this.rokProdukcji = rokProdukcji;
		this.rodzajPaliwa = rodzajPaliwa;
		this.pojemnosc = pojemnosc;
	}

	@Override
	public String toString() {
		return "Samochod{" +
				"idSamochod=" + idSamochod +
				", idModel=" + idModel +
				", moc='" + moc + '\'' +
				", rokProdukcji='" + rokProdukcji + '\'' +
				", rodzajPaliwa='" + rodzajPaliwa + '\'' +
				", pojemnosc='" + pojemnosc + '\'' +
				'}';
	}

	public int getIdSamochod() {
		return idSamochod;
	}
	public int getIdModel() {
		return idModel;
	}
	public String getMoc() {
		return moc;
	}
	public String getRokProdukcji() {
		return rokProdukcji;
	}
	public String getRodzajPaliwa() {
		return rodzajPaliwa;
	}
	public String getPojemnosc() {
		return pojemnosc;
	}
}
