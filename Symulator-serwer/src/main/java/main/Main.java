package main;


import komunikacja.Komunikacja;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.*;

/**
 * <h2>Klasa główna z metodą main.</h2>
 * <p></p>
 */
public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    private ServerSocket gniazdoServer;
    private int Port = 6000;
    private ServerSocket gniazdoSerwer;
    private Socket gniazdoKlienta;



    public static void main(String[] args){
        logger.info("Włączenie serwera");
        Main server = new Main();
        server.dzialanie();
    }
    public Main() {}

    public Main(int port) {
        this.Port = port;
    }

    /**
     * Metoda uruchamia server
     */
    public void dzialanie(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error("Brak sterownika",e);
        }

        try {
            gniazdoSerwer = new ServerSocket(Port);
        } catch (IOException e) {
            logger.error("Brak sterownika",e);
        }
        while(true) {
            try {
                gniazdoKlienta = gniazdoSerwer.accept();
            } catch (IOException e) {
                logger.error("Brak sterownika",e);
            }
            Komunikacja s2 = new Komunikacja(Port, "localhost", gniazdoKlienta);
            Thread t = new Thread(s2);
            t.start();
        }
    }
}