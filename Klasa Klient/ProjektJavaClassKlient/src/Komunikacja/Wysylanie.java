package Komunikacja;

import java.io.*;
import java.net.Socket;

public class Wysylanie {
	private PrintWriter nadawca;
	private BufferedReader odbiorca;
	private Socket gniazdo;
	  
	private String IP = "127.0.0.1";
	private int Port = 6000;
	 
	public void setPort(int port){
		this.Port = port;
	}
	public void setIP(String IP){
		this.IP = IP;
	}
	public String dzialanie(String marka , String model , String km , String paliwo , String silnik){   
		konfigurujKomunikacje();
		
		String markaP = dostosuj(marka);
		String modelP = dostosuj(model);
		String kmP;
		if(liczby(km)){
			kmP = km;
		}else {
			return "KM powinny byæ liczb¹";
		}
		String paliwoP = dostosujPaliwo(paliwo); 
		if(paliwoP == null){
			return "Brak takiego rozdaju paliwa";
		}
		String silnikP;
		if(liczby(silnik)){
			silnikP = silnik;
		}else {
			return "Pojemnisc powinna byæ liczb¹";
		}
		
	    wyslij(markaP , modelP , kmP , paliwoP , silnikP);
	    String wiadomosc = null;
	    try{
		    while( (wiadomosc = odbiorca.readLine()) != null ) {
		    	return wiadomosc;
		    }
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }
		return wiadomosc;   
 	}
	public void wyslij(String marka , String model , String km , String paliwo , String silnik){
		try {
			nadawca.println(marka); 
			nadawca.println(model); 
			nadawca.println(km); 
			nadawca.println(paliwo); 
			nadawca.println(silnik); 
			nadawca.flush();
		}catch(Exception ex){ 
			ex.printStackTrace();
		}  
	}
	private void konfigurujKomunikacje() {
	  try {
		  gniazdo = new Socket(IP , Port);     
		  InputStreamReader czytelnikStrm = new InputStreamReader(gniazdo.getInputStream());  
		  odbiorca = new BufferedReader(czytelnikStrm);   
		  nadawca = new PrintWriter(gniazdo.getOutputStream());  
		  System.out.println("Klient gotowy do uzycia"); 
	  }catch(IOException ex) {
		  ex.printStackTrace();
	  }
	}
	private String dostosuj(String napis){
		return napis.toLowerCase();
	}
	private boolean liczby(String napis){
		for(int i=0;i<napis.length();++i){
		        if(napis.charAt(i)<='0'|| napis.charAt(i)>='9'|| napis.charAt(i)>='.'){
		                return true;
		         }
		} 
		return false;
	}
	private String dostosujPaliwo(String napis){
		napis = dostosuj(napis);
		if(napis.equals("gaz") || napis.equals("benzyna") || napis.equals("diesel") || napis.equals("hybryda")){
			return napis;
		}else{
			return null;
		}
	}
}
