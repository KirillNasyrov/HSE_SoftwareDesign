package kirillnasyrov.models;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public String getFilePath() {
        return scanner.next();
    }
}
