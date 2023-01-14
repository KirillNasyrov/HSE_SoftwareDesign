package kirillnasyrov.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileNode {
    protected final Path currentFile;
    protected final String data;

    public FileNode(Path path) throws FileNotFoundException {
        currentFile = path;
        BufferedReader temporaryReader = new BufferedReader(new FileReader(path.toFile().getPath()));
        data = temporaryReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public Path getCurrentFile() {
        return currentFile;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileNode fileNode = (FileNode) o;
        return currentFile.equals(fileNode.currentFile) && data.equals(fileNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentFile, data);
    }
}
