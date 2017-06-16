package Komunikacja;

import java.io.BufferedReader;

public class Odbieranie implements Runnable{
	
	BufferedReader odbiorca;	
	String wiadomosc;
	
	public Odbieranie(BufferedReader odbiorca){
		this.odbiorca = odbiorca;
	}
	public void run() { 
		try {
			while( (wiadomosc = odbiorca.readLine()) != null ) {
				System.out.println("Odczytano: " + wiadomosc); 
			}    
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	public String odebrane(){
		return wiadomosc;
	}
}
