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
        BufferedReader in = null;
        ObjectOutputStream objectOut = null;
        PrintWriter out = null;

        try {
            echoSocket = new Socket(InetAddress.getLocalHost(), PORT);
            objectOut = new ObjectOutputStream(echoSocket.getOutputStream());
            objectOut.flush();
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
            out = new PrintWriter(echoSocket.getOutputStream(), true);
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
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader( new
                InputStreamReader(System.in));

        String userInput;
        //PersistentTime time = new PersistentTime();
        Date date = new Date();

        try{
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                //objectOut.writeObject(time);
                objectOut.writeObject(date);
                objectOut.flush();
                if (userInput.equals("Bye."))
                    break;
                System.out.println("echo: " + in.readLine());
            }
            objectOut.close();
            in.close();
            stdIn.close();
            echoSocket.close();
        } catch (IOException ioe) {
            System.out.println("Failed");
            System.exit(-1);
        }}}