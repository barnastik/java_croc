package barnastik.homework7.task14;

import java.io.IOException;
import java.net.Socket;
import java.io.*;

class Client implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;

    Client(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("Received message: " + message);
                Server.broadcastMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
