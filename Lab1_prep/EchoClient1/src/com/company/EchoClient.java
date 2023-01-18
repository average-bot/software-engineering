package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class EchoClient {
    Integer PORT = 1234;
    public EchoClient() { }
    public void establish() {
        Socket echoSocket = null;
        ObjectOutputStream oos = null;

        try {
            echoSocket = new Socket(InetAddress.getLocalHost(), PORT);
            oos = new ObjectOutputStream(echoSocket.getOutputStream());

            /*
            System.out.println(echoSocket.getInetAddress());
            // DESKTOP-7R2D7U7/192.168.0.80
            System.out.println(echoSocket.getLocalPort());
            // 61046 <- client port
            InetAddress inetAddress = echoSocket.getInetAddress();
            System.out.println(inetAddress);
            // DESKTOP-7R2D7U7/192.168.0.80
            System.out.println(echoSocket.getPort());
            // 2345
            System.out.println("----");
            System.out.println(inetAddress.getCanonicalHostName());
            // 192.168.0.80
            System.out.println(inetAddress.getHostAddress());
            // 192.168.0.80
            System.out.println(inetAddress.getHostName());
            // DESKTOP-7R2D7U7
            */
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;

        try{
            while ((userInput = stdIn.readLine()) != null) {
                PersistentTime persistentTime = new PersistentTime();
                oos.writeObject(persistentTime);
                System.out.println("delivered: " + persistentTime.getTime());
                if (userInput.equals("q"))
                    break;
            }
            oos.close();
            stdIn.close();
            echoSocket.close();
        } catch (IOException ioe) {
            System.out.println("Failed");
            System.exit(-1);
        }}}