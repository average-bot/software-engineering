package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class EchoServer {
    Integer PORT = 1250;
    public EchoServer() { }
    public void establish() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        try {
            serverSocket= new ServerSocket(PORT);
        }catch (IOException e) {
            System.out.println("Could not listen on port: 1234");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("connect");
        }catch (IOException e) {
            System.out.println("Accept failed: 1234");
            System.exit(-1);
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(clientSocket.getInputStream());
        }catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
        PersistentTime persistentTime;

        try {
            while ((persistentTime = (PersistentTime) ois.readObject()) != null) {
                System.out.println("Message sent time: " + persistentTime.getTime());
                System.out.println("Message arrival time: "+ Calendar.getInstance().getTime());
            }
        }catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }
        try {
            fis.close();
            ois.close();
            clientSocket.close();
            serverSocket.close();
        }catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }
    }
}