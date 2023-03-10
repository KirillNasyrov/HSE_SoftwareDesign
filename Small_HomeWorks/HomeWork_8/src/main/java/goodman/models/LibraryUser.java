package goodman.models;

import java.util.Map;
import java.util.Optional;

public class LibraryUser extends Person {
    private final StorageOfBooks booksOfUser;
    public LibraryUser(String firstName, String secondName) {
        super(firstName, secondName);
        booksOfUser = new StorageOfBooks();
    }
    public Optional<Book> returnTheBook(String title) {
        return booksOfUser.getBookByTitle(title);
    }

    public void takeTheBook(Book book) {
        if (book != null) {
            booksOfUser.putBook(book);
        }
    }

    public Map<Book, Integer> getBooksOfUser() {
        return booksOfUser.getCollectionOfBooks();
    }
}
