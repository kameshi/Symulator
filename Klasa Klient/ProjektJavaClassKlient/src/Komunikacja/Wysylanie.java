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
	public String dzialanie(String marka , String model , String km , String paliwo , String silnik , String spalanie){   
		konfigurujKomunikacje();
		Odbieranie klient = new Odbieranie(odbiorca);
	    Thread watekOdbiorcy = new Thread(klient); 
	    watekOdbiorcy.start();
	    wyslij(marka , model , km , paliwo , silnik , spalanie);
	    return klient.odebrane();
 	}
	public void wyslij(String marka , String model , String km , String paliwo , String silnik , String spalanie){
		try {
			nadawca.println(marka); 
			nadawca.println(model); 
			nadawca.println(km); 
			nadawca.println(paliwo); 
			nadawca.println(silnik); 
			nadawca.println(spalanie); 
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
}
