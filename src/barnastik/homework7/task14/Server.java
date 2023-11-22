package barnastik.homework7.task14;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 8080;
    private static ArrayList<PrintWriter> clientOutputStreams;

    public static void main(String[] args) {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new Client(clientSocket));
                t.start();
                System.out.println("Got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message) {
        for (PrintWriter clientWriter : clientOutputStreams) {
            clientWriter.println(message);
            clientWriter.flush();
        }
    }
}

