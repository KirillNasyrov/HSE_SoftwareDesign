package goodman;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static final int PORT = 8080;
    public static List<ServerHandler> serverList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerHandler(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}