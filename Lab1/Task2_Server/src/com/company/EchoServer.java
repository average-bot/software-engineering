package com.company;
import java.io.*;
import java.net.*;

public class EchoServer {
    public EchoServer() {

    }
    public void establish() {
        InputStream input = null;
        ServerSocket serverSocket = null;
        BufferedReader reader = null;
        try {
            serverSocket = new ServerSocket(1234);
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
        try {
            input = clientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        }catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
        String inputLine, outputLine;
        try {
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);

            }
        }catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }
        try {
            input.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();
        }catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }}
}

