package Komunikacja;

import java.util.Scanner;

public class Komunikacja {
	
	private String wiadomosc;
	
	private Wysylanie wysylanie = new Wysylanie();
//	/*Przyk�ad dzia�ania
	public static void main(String[] args){
		Scanner scannerI = new Scanner(System.in);
		Scanner scannerS = new Scanner(System.in);
		Komunikacja k = new Komunikacja();	
		boolean n = true;
		do{
			System.out.println("Podaj co robic \n1.nowe auto\n2.stare auto\n3.koniec");
			int kon;
			kon = scannerI.nextInt(); 
			if(kon == 1){
				String marka, model, km, paliwo, silnik;
				System.out.println("Marka: ");
				marka = scannerS.nextLine();
				System.out.println("Modle: ");
				model = scannerS.nextLine();
				System.out.println("KM: ");
				km = scannerS.nextLine();
				System.out.println("Paliwo: ");
				paliwo = scannerS.nextLine();
				System.out.println("Silnik: ");
				silnik = scannerS.nextLine();
				k.wyslij(marka, model, km, paliwo, silnik);
				System.out.println("Srednie spalanie na " + km + " Km " + " wynosi: " + k.odebrane());
			}else if(kon == 2){
				
			}else if(kon == 0){
				n = false;
			}
		}while(n);
	}
//	*/
	public void komunikacja(){}
	public void komunikacja(int port , String IP){
		wysylanie.setPort(port);
		wysylanie.setIP(IP);
	}
	public void wyslij(String marka , String model , String km , String paliwo , String silnik){
		this.wiadomosc = wysylanie.dzialanie(marka, model, km, paliwo, silnik);
	}
	public String odebrane(){
		return wiadomosc;
	}
}
