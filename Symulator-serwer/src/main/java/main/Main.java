package main;



import komunikacja.Komunikacja;

import java.io.FileNotFoundException;
import java.net.*;

public class Main {

    private ServerSocket gniazdoServer;
    private int Port = 6000;

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Main server = new Main();
        server.dzialanie();
    }
    public Main() {
    }

    public Main(int port) {
        this.Port = port;
    }

    public void dzialanie() {
        try {
            gniazdoServer = new ServerSocket(Port);
            System.out.println("Server w��czony.");
            while (true) {
                Socket gniazdoKlient = gniazdoServer.accept();
                Thread t = new Thread(new Komunikacja(gniazdoKlient));
                t.start();
                System.out.println("Po��czenie uzyskane z klientem.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}