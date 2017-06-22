package main;



import bazaDanych.ObslugaBazyDanych;
import dane.BazaDanych;
import komunikacja.Komunikacja;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.SQLException;

public class Main {
    private ServerSocket gniazdoServer;
    private int Port = 6000;
    private ServerSocket gniazdoSerwer;
    private Socket gniazdoKlienta;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Main server = new Main();
        server.dzialanie();
    }
    public Main() {}

    public Main(int port) {
        this.Port = port;
    }

    public void dzialanie() throws ClassNotFoundException, IOException, SQLException {
        String host = InetAddress.getLocalHost().getHostName();
        gniazdoSerwer = new ServerSocket(Port);
        while(true) {
            gniazdoKlienta = gniazdoSerwer.accept();
            Komunikacja s2 = new Komunikacja(Port, "localhost", gniazdoKlienta);

            Thread t = new Thread(s2);
            t.start();
        }
    }
}