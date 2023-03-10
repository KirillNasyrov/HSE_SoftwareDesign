package goodman.models;

import java.util.*;

public class Library {
    private final StorageOfBooks booksOfLibrary;

    public Library() {
        this.booksOfLibrary = new StorageOfBooks();
    }

    public Optional<Book> getBookByTitle(String title) {
        return booksOfLibrary.getBookByTitle(title);
    }
    public void addBook(Book book) {
        if (book != null) {
            booksOfLibrary.putBook(book);
        }
    }
    public Map<Book, Integer> getBooksOfLibrary() {
        return booksOfLibrary.getCollectionOfBooks();
    }
}
