package goodman.controllers;

import goodman.constants.CommandStrings;
import goodman.models.Book;
import goodman.view.ConsoleHandler;
import goodman.models.Library;
import goodman.models.LibraryUser;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserController {
    private final ConsoleHandler consoleHandler;

    public UserController() {
        consoleHandler = new ConsoleHandler();
    }

    public void get(Library library, LibraryUser libraryUser, String title) {
        Optional<Book> book = library.getBookByTitle(title);
        book.ifPresent(libraryUser::takeTheBook);
    }

    public void put(Library library, LibraryUser libraryUser, String title) {
        Optional<Book> book = libraryUser.returnTheBook(title);
        book.ifPresent(library::addBook);
    }

    public void list(LibraryUser libraryUser) {
        Map<Book, Integer> books = libraryUser.getBooksOfUser();
        consoleHandler.printBooks(books);
    }

    public void all(Library library) {
        Map<Book, Integer> books = library.getBooksOfLibrary();
        consoleHandler.printBooks(books);
    }

    public void startProcess(Library library, LibraryUser libraryUser) {
        String[] command = consoleHandler.getCommand();
        while (!Objects.equals(command[0], CommandStrings.exitCommand)) {
            if (command[0].equals(CommandStrings.getCommand)) {
                get(library, libraryUser, command[1]);
            } else if (command[0].equals(CommandStrings.allCommand)) {
                all(library);
            } else if (command[0].equals(CommandStrings.listCommand)) {
                list(libraryUser);
            } else if (command[0].equals(CommandStrings.putCommand)) {
                put(library, libraryUser, command[1]);
            } else {
                System.out.println("Wrong command");
            }
            command = consoleHandler.getCommand();
        }
    }
}
