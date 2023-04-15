package goodman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// нить чтения сообщений с сервера
class ReadMsg extends Thread {
    private static Socket clientSocket;
    private static BufferedReader in;
    @Override
    public void run() {

        String str;
        try {

            clientSocket = new Socket("localhost", 4004);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                str = in.readLine();
                if (str.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {

        }
    }
}