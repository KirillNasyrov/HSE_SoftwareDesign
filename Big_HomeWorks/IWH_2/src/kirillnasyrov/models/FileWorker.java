package kirillnasyrov.models;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    private final Path mainPath;
    private final ArrayList<FileNode> resolvedFiles;
    private final ArrayList<FileNode> unresolvedFiles;
    private final Pattern patternOfDirective = Pattern.compile("^require '.+.txt'$");
    private final Pattern patternOfFile = Pattern.compile("'.+.txt'");

    public FileWorker(Path path) {
        mainPath = path;
        resolvedFiles = new ArrayList<>();
        unresolvedFiles = new ArrayList<>();
    }

    /**
     * Метод, который находит все зависимости между файлами и сортитурет их
     * @param node узловой файл
     * @throws IOException исключение связанное при работе с файлами
     */
    public void findDependentFiles(FileNode node) throws IOException {
        unresolvedFiles.add(node);

        Scanner scanner = new Scanner(node.getCurrentFile());
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            Matcher matcherOfDirective = patternOfDirective.matcher(line);
            if (matcherOfDirective.matches()) {
                Matcher matcherOfFile = patternOfFile.matcher(line);
                if (matcherOfFile.find()) {
                    String buffer = line.substring(matcherOfFile.start(), matcherOfFile.end());
                    String pathOfDependentFile = mainPath.toFile().getPath() + "/" + buffer.substring(1, buffer.length() - 1);

                    Path dependentFile = Paths.get(pathOfDependentFile);

                    FileNode dependentFileNode = new FileNode(dependentFile);

                    if (!resolvedFiles.contains(dependentFileNode)) {
                        if (unresolvedFiles.contains(dependentFileNode)) {
                            throw new RuntimeException("Найдена циклическая зависимость");
                        }
                        findDependentFiles(dependentFileNode);
                    }
                }
            }
        }

        resolvedFiles.add(node);
        unresolvedFiles.remove(node);
    }

    public ArrayList<FileNode> findSequence() throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(mainPath)) {
            for (Path file : stream) {
                if (file.toFile().isFile()) {
                    FileNode firstNode = new FileNode(file);
                    findDependentFiles(firstNode);
                    break;
                }
            }
        }
        return new ArrayList<>(resolvedFiles);
    }

    public void printSequence(ArrayList<FileNode> arrayList) {
        for (FileNode node : arrayList) {
            System.out.println(node.getCurrentFile().toFile().getName());
        }
    }

    /**
     * Создает файл и конкатенирует туда файлы из последовательности
     * @param fileName имя нового файла
     * @param arrayList последовательность файлов
     */
    public void createNewFileAndWriteData(String fileName, ArrayList<FileNode> arrayList) {
        Path file = Paths.get(mainPath.toFile().getPath() + "/" + fileName);
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException x) {
            System.err.format("файл с названием %s" + " уже существует%n", file);
        } catch (IOException x) {
            System.err.format("ошибка создания файла: %s%n", x);
        }


        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (FileNode node : arrayList) {
                writer.write(node.getData() + "\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
