package kirillnasyrov;

import java.io.*;
import java.util.Iterator;

class FileIterator implements Iterator<String> {
    private final String path;
    BufferedReader bufferedReader;

    public FileIterator(String path) throws FileNotFoundException {
        this.path = path;
        bufferedReader = new BufferedReader(new FileReader(this.path));
    }

    @Override
    public boolean hasNext() {
        try {
            bufferedReader.mark(1);
            int character = bufferedReader.read();
            if (character == -1) {
                return false;
            }
            bufferedReader.reset();
            return true;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public String next() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
















