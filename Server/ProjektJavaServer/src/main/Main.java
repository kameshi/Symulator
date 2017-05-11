package main;

import java.io.*;
import java.net.*;

import komunikacja.ObslugaKlienta;

public class Main {//liczby z przecinkiem "," podajemy z kropk¹ "." istotne !!!!!!!!!!!!!!!!!

	private ServerSocket gniazdoServer;
	private int Port = 6000;
	
	public static void main(String[] args) throws FileNotFoundException{
		Main server = new Main();
		server.dzialanie();
	}
	public Main(){}
	public Main(int port){
		this.Port = port;
	}
	public void dzialanie(){
		try{
			gniazdoServer = new ServerSocket(Port);
			System.out.println("Server w³¹czony.");
			while(true){
				Socket gniazdoKlient = gniazdoServer.accept();
				PrintWriter pisarz = new PrintWriter(gniazdoKlient.getOutputStream());
	
				Thread t = new Thread(new ObslugaKlienta(gniazdoKlient,pisarz));
				t.start();
				System.out.println("Po³¹czenie uzyskane z klientem.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
