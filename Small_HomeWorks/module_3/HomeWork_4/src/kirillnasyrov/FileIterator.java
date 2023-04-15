package kirillnasyrov;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

class FileIterator implements Iterator<String>, Closeable {
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
            if (hasNext()) {
                return bufferedReader.readLine();
            }
            throw new NoSuchElementException("no element");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
















