package Komunikacja;

import dane.BazaHistoria;
import dane.DaneAuta;
import dane.Historia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Komunikacja{
	private int port;
	private Socket gniazdoKlienta;
	private ObjectOutputStream pisarz;
	private ObjectInputStream czytelnik;
	private String host;
	public Komunikacja(String host, int port) throws IOException {
		host = host;
		port = port;
		gniazdoKlienta = new Socket("127.0.0.1", 6000);
		pisarz = new ObjectOutputStream(gniazdoKlienta.getOutputStream());
		czytelnik = new ObjectInputStream(gniazdoKlienta.getInputStream());
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
