package kirillnasyrov;

import kirillnasyrov.models.ConsoleReader;
import kirillnasyrov.models.FileNode;
import kirillnasyrov.models.FileWorker;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        Path mainPath = reader.getFilePath();
        FileWorker checker = new FileWorker(mainPath);
        ArrayList<FileNode> arr;
        try {
            arr = checker.findSequence();
        } catch (IOException exception) {
            System.out.print("неверно указан файл: ");
            System.out.println(exception.getMessage());
            return;
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        checker.printSequence(arr);
        String fileName = reader.getFileNameForCreating();
        checker.createNewFileAndWriteData(fileName, arr);
    }
}
