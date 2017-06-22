package komunikacja;

import dane.BazaHistoria;
import dane.DaneAuta;
import dane.Historia;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Komunikacja{

	private final static Logger logger = Logger.getLogger(Komunikacja.class);

	private int port;
	private Socket gniazdoKlienta;
	private ObjectOutputStream pisarz;
	private ObjectInputStream czytelnik;
	private String host;
	public Komunikacja(String host, int port){
		host = host;
		port = port;
		try {
			gniazdoKlienta = new Socket("127.0.0.1", 6000);
		} catch (IOException e) {
			//logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
		try {
			pisarz = new ObjectOutputStream(gniazdoKlienta.getOutputStream());
		} catch (IOException e) {
			//logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
		try {
			czytelnik = new ObjectInputStream(gniazdoKlienta.getInputStream());
		} catch (IOException e) {
			//logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
	}
	public void wyslij(String semafor) {
		try {
			pisarz.flush();
			pisarz.writeObject(semafor);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	public void wyslij(DaneAuta auto) {
		try {
			pisarz.flush();
			pisarz.writeObject(auto);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	public void wyslij(Historia historia) {
		try {
			pisarz.flush();
			pisarz.writeObject(historia);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	public BazaHistoria odbierz() {
		BazaHistoria baza = null;
		try {
			baza = (BazaHistoria) czytelnik.readObject();
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);
		}
		return baza;
	}
	public boolean odbierzKontrol() {
		boolean kontrol = false;
		try {
			kontrol = (boolean) czytelnik.readObject();
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);
		}
		return kontrol;
	}
}
