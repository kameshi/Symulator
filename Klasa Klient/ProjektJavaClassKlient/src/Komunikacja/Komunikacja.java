package Komunikacja;


public class Komunikacja {
	
	private String wiadomosc;
	
	private Wysylanie wysylanie = new Wysylanie();
	/*Przyk³ad dzia³ania
	public static void main(String[] args){
		Komunikacja k = new Komunikacja();
		k.wyslij("marka","model","100","Gaz","100","100");
		System.out.println(k.odebrane());
	}
	*/
	public void komunikacja(){}
	public void komunikacja(int port , String IP){
		wysylanie.setPort(port);
		wysylanie.setIP(IP);
	}
	public void wyslij(String marka , String model , String km , String paliwo , String silnik , String spalanie){
		this.wiadomosc = wysylanie.dzialanie(marka, model, km, paliwo, silnik, spalanie);
	}
	public void wyslij(String marka , String model , String km , String paliwo , String silnik){
		this.wiadomosc = wysylanie.dzialanie(marka, model, km, paliwo, silnik, "0");
	}
	public String odebrane(){
		return wiadomosc;
	}
}
