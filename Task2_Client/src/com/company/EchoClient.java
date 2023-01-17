package com.company;

import java.io.*;
import java.net.*;

public class EchoClient {
    public EchoClient() { }
    public void establish() {
        Socket echoSocket = null;
        OutputStream output = null;
        PrintWriter writer = null;
        try {
            echoSocket = new Socket(InetAddress.getLocalHost(), 1234);
            output = echoSocket.getOutputStream();
            writer = new PrintWriter(output, true);
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

        try{
            while ((userInput = stdIn.readLine()) != null) {
                writer.println(userInput);
            }
            output.close();
            writer.close();
            stdIn.close();
            echoSocket.close();
        } catch (IOException ioe) {
            System.out.println("Failed");
            System.exit(-1);
        }}
}
