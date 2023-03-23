package goodman;

import java.io.*;
import java.net.*;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {

        try (Socket echoSocket = new Socket("localhost", 4000);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {


            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Отправлено сообщение: " + userInput);

                // считываем ответ от сервера и выводим его на экран
                String response = in.readLine();
                System.out.println("Получен ответ: " + response);
            }
        } catch (UnknownHostException e) {
            System.err.println("Неизвестный хост: localhost");
        } catch (IOException e) {
            System.err.println("Ошибка при подключении к серверу");
        }
    }
}