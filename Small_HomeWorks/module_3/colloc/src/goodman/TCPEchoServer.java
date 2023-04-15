package goodman;

import java.io.*;
import java.net.*;

public class TCPEchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(4000);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            System.out.println("Сервер смог запуститься");

            try {
                System.out.println("Клиент подключен");
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Получено сообщение: " + inputLine);
                    out.println(inputLine);
                }

                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Ошибка при подключении клиента");
            }
        } catch (IOException e) {
            System.err.println("Невозможно открыть порт 8000");
        }
    }
}