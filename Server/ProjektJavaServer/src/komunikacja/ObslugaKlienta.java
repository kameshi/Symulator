package komunikacja;

import java.io.*;
import java.net.Socket;
import java.util.*;

import przeliczanie.Przeliczanie;

public class ObslugaKlienta implements Runnable{
	
	BufferedReader czytelnik;
	Socket gniazdo;
	ArrayList<PrintWriter> strumien;
	
	private void getList(){
		ArrayList<PrintWriter> strumien = new ArrayList<PrintWriter>();
		this.strumien = strumien;
	}
	public ObslugaKlienta(Socket gniazdoKlienta, PrintWriter pisarz){
		try{
			gniazdo = gniazdoKlienta;
			InputStreamReader isReader = new InputStreamReader(gniazdo.getInputStream());
			czytelnik= new BufferedReader(isReader);
			getList();
			strumien.add(pisarz);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void rozeslanie(String wiadomosc){
		Iterator<PrintWriter> it = strumien.iterator();
		while(it.hasNext()){
			try{
				PrintWriter pisarz = (PrintWriter) it.next();
				pisarz.println(wiadomosc);
				pisarz.flush();
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	public void run() {
		String marka , model , iloscKM , Rodzajpaliwa , silnik , sredniSpalanie;
		try{
			while( (marka = czytelnik.readLine()) != null){
				while( (model = czytelnik.readLine()) != null){
					while( (iloscKM = czytelnik.readLine()) != null){
						while( (Rodzajpaliwa = czytelnik.readLine()) != null){
							while( (silnik = czytelnik.readLine()) != null){
								while( (sredniSpalanie = czytelnik.readLine()) != null){
									System.out.println("Odebrano: " + marka);
									Przeliczanie p = new Przeliczanie();
									rozeslanie( p.dzialanie(marka, model, iloscKM, Rodzajpaliwa, silnik, sredniSpalanie));
								}
							}
						}
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
