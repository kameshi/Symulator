package przeliczanie;

public class DaneAut {
	private double srednieSpalanie, rodzajSilnika;
	private String marka, model , rodzajPaliwa;
	
	public DaneAut(String marka, String model, double srednieSpalanie, double rodzajSilnika, String rodzajPaliwa){
		this.marka = marka;
		this.model = model;
		this.srednieSpalanie = srednieSpalanie;
		this.rodzajSilnika = rodzajSilnika;
		this.rodzajPaliwa = rodzajPaliwa;
	}
	public double getSrednieSpalanie(){
		return srednieSpalanie;
	}
	public double getRodzajSilnika(){
		return rodzajSilnika;
	}
	public String getRodzajPaliwa(){
		return rodzajPaliwa;
	}
	public String getMarka(){
		return marka;
	}
	public String getModel(){
		return model;
	}
	
}
