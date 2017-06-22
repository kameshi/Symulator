package main;



import bazaDanych.ObslugaBazyDanych;
import dane.BazaDanych;
import komunikacja.Komunikacja;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.SQLException;

public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    private ServerSocket gniazdoServer;
    private int Port = 6000;

    public static void main(String[] args){
        logger.info("Włączenie serwera");
        Main server = new Main();
        server.dzialanie();
    }
    public Main() {}

    public Main(int port) {
        this.Port = port;
    }

    public void dzialanie(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error("Brak sterownika",e);
        }
        int Port = 6000;
       
            Komunikacja s2 = new Komunikacja(Port, host);
            Thread t = new Thread(s2);
            t.start();


       /* try {
            gniazdoServer = new ServerSocket(Port);
            System.out.println("Server w��czony.");

            while (true) {

                Komunikacja k = new Komunikacja(gniazdoServer);
                Thread t = new Thread(k);
                t.start();
                System.out.println("Po��czenie uzyskane z klientem.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}