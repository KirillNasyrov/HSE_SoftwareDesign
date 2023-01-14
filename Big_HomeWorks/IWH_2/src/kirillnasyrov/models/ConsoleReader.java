package kirillnasyrov.models;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public Path getFilePath() {
        System.out.print("Введите путь файла: ");
        String pathOfFile = scanner.next();
        return Paths.get(pathOfFile);
    }

    public String getFileNameForCreating() {
        System.out.print("Введите имя файла: ");
        return scanner.next();
    }
}
