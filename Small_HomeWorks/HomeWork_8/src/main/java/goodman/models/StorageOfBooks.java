package goodman.models;

import goodman.view.ConsoleHandler;

import java.util.*;

public class StorageOfBooks {
    private final Map<Book, Integer> collectionOfBooks;
    private final ConsoleHandler consoleHandler;

    public StorageOfBooks() {
        this.consoleHandler = new ConsoleHandler();
        collectionOfBooks = new HashMap<>();
    }

    public void putBook(Book book) {
        if (book != null) {
            if (collectionOfBooks.containsKey(book)) {
                collectionOfBooks.put(book, collectionOfBooks.get(book) + 1);
            } else {
                collectionOfBooks.put(book, 1);
            }
        }
    }

    public Optional<Book> getBookByTitle(String title) {
        List<Book> booksWithGivenTitle = new ArrayList<>();
        for (Book book : collectionOfBooks.keySet()) {
            if (book.getTitle().equals(title) && collectionOfBooks.get(book) > 0) {
                booksWithGivenTitle.add(book);
            }
        }
        if (booksWithGivenTitle.size() == 0) {
            consoleHandler.printNoBooksMessage();
            return Optional.empty();
        } else if (booksWithGivenTitle.size() == 1) {
            collectionOfBooks.put(booksWithGivenTitle.get(0), collectionOfBooks.get(booksWithGivenTitle.get(0)) - 1);
            return Optional.of(booksWithGivenTitle.get(0));
        } else {
            consoleHandler.printBooks(booksWithGivenTitle);
            Book chosenBook = booksWithGivenTitle.get(consoleHandler.chooseTheBook(booksWithGivenTitle.size()));
            collectionOfBooks.put(chosenBook, collectionOfBooks.get(chosenBook) - 1);
            return Optional.of(chosenBook);
        }
    }

    public Map<Book, Integer> getCollectionOfBooks() {
        return new HashMap<>(collectionOfBooks);
    }
}
