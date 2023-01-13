package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class EchoServer {
    Integer PORT = 1234;
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
        }catch (IOException e) {
            System.out.println("Accept failed: 1234");
            System.exit(-1);
        }
        PrintWriter out=null;
        BufferedReader in = null;
        ObjectInputStream ois = null;
        try {
            out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            ois = new ObjectInputStream(clientSocket.getInputStream());
        }catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
        String inputLine, outputLine;


        //PersistentTime time = null;
        Date date;

        // TODO: FIX while ((date = (Date) ois.readObject()) != null) { }
        try {
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                //time = (PersistentTime) ois.readObject();
                date = (Date) ois.readObject();
                //System.out.println("Message sent time: " + time.getTime());
                System.out.println(inputLine);
                System.out.println(date);
                System.out.println("Message delivered time: "+ Calendar.getInstance().getTime());
                if (inputLine.equals("Bye."))
                    break;
            }
        }catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }
        try {
            clientSocket.close();
            serverSocket.close();
            ois.close();
        }catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }}}