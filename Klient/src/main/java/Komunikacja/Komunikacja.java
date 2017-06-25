package komunikacja;

import dane.BazaWiersz;
import dane.DaneAuta;
import dane.Historia;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <h2>Klasa komunikujaca sie z serverem .</h2>
 * <p>Posiada metody pozwalające obsługiwać server w komunikacji z klientem.</p>
 */
public class Komunikacja{

	private final static Logger logger = Logger.getLogger(Komunikacja.class);

	private int port;
	private Socket gniazdoKlienta;
	private ObjectOutputStream pisarz;
	private ObjectInputStream czytelnik;
	private String host;

	/**
	 * Metoda wysyła dane na server.
	 * @param host host lokalny
	 * @param port port na którym server oczekuje i wysyła dane
	 */
	public Komunikacja(String host, int port){
		this.host = host;
		this.port = port;
		try {
			gniazdoKlienta = new Socket("127.0.0.1", 6000);
		} catch (IOException e) {
			logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
		try {
			pisarz = new ObjectOutputStream(gniazdoKlienta.getOutputStream());
		} catch (IOException e) {
			logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
		try {
			czytelnik = new ObjectInputStream(gniazdoKlienta.getInputStream());
		} catch (IOException e) {
			logger.error("NIe można załadować strony aktualizuj dane.",e);
		}
	}
	/**
	 * Metoda wysyła dane na server.
	 * @param semafor zmienna typu String wysyłana na server
	 */
	public void wyslij(String semafor) {
		try {
			pisarz.flush();
			pisarz.writeObject(semafor);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	/**
	 * Metoda wysyła dane na server.
	 * @param auto zmienna typu DaneAuto wysyłana na server
	 */
	public void wyslij(DaneAuta auto) {
		try {
			pisarz.flush();
			pisarz.writeObject(auto);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	/**
	 * Metoda wysyła dane na server.
	 * @param historia zmienna typu Historia wysyłana na server
	 */
	public void wyslij(Historia historia) {
		try {
			pisarz.flush();
			pisarz.writeObject(historia);
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);    }
	}
	/**
	 * Metoda odbiera dane z server-a.
	 * @return BazaWiersz zwraca odebraną baze wierszy do historii
	 */
	public BazaWiersz odbierz() {
		BazaWiersz baza = null;
		try {
			baza = (BazaWiersz) czytelnik.readObject();
		} catch(Exception e) {
			System.out.println("Wyjatek klienta " + e);
		}
		return baza;
	}
	/**
	 * Metoda odbiera dane z server-a.
	 * @return boolean zwraca kontrolną zmienna logiczna
	 */
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
