package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServer extends Thread {
    Integer PORT = 1234;
    public MultiClientServer() {}
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket= new ServerSocket(PORT);
            System.out.println(serverSocket.getInetAddress());
            // gives 0.0.0.0 when its not connected to TCP/IP network

            System.out.println(serverSocket.getLocalPort());
            // the PORT number where its listening

        }catch (IOException e) {
            System.out.println("Could not listen on port:" + PORT);
            System.exit(-1);
        }

        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                Server server = new Server(clientSocket);
                server.start();
                System.out.println(clientSocket.getInetAddress());
                // 192.168.0.80
                System.out.println(clientSocket.getLocalPort());
                // 2345
                InetAddress inetAddress = clientSocket.getInetAddress();
                System.out.println(inetAddress);
                // 192.168.0.80
                System.out.println(clientSocket.getPort());
                // 49731 <- client changes port for every connection
                System.out.println("-------");
                System.out.println(inetAddress.getCanonicalHostName());
                // 192.168.0.80
                System.out.println(inetAddress.getHostAddress());
                // 192.168.0.80
                System.out.println(inetAddress.getHostName());
                // 192.168.0.80
            } catch (IOException e) {
                System.out.println("Accept failed:2345");
                System.exit(-1);
            }
        }
}
}
