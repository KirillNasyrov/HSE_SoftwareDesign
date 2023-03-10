package goodman.controllers;

import goodman.models.Book;
import goodman.models.Library;
import goodman.models.LibraryUser;
import goodman.models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Test
    public void testCreateEmptyLibrary() {
        Library library = new Library();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
    }
    @Test
    public void testFindBookEmptyLibrary() {
        Library library = new Library();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        Optional<Book> book = library.getBookByTitle("someTitle");
        Assertions.assertTrue(book.isEmpty(), "Должен возвращаться нулевой объект при взятии книги из пустой библиотеки");
    }

    @Test
    public void testAddBooksToEmptyLibrary() {
        Library library = new Library();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        for (int i = 0; i < 3; ++i) {
            library.addBook(new Book("Джордан Хэндерсон: Автобиография", 2022, List.of(new Person[]{new Person("Джордан", "Хэндерсон")})));
        }
        for (int i = 0; i < 2; ++i) {
            library.addBook(new Book("Приключения Тома Сойера", 1876, List.of(new Person[]{new Person("Марк", "Твен")})));
        }
        Assertions.assertEquals(2, library.getBooksOfLibrary().size());
    }
    @Test
    public void testTwoSameBooksInLibrary() {
        Library library = new Library();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        Book book1 = new Book("title", 2023, List.of(new Person[]{new Person("name", "surname")}));
        Book book2 = new Book("title", 2023, List.of(new Person[]{new Person("name", "surname")}));
        library.addBook(book1);
        library.addBook(book2);
        Assertions.assertEquals(1, library.getBooksOfLibrary().size());
        Assertions.assertEquals(2, library.getBooksOfLibrary().get(book1));
    }

    @Test
    public void testTakingBookWhichIsNotInLibrary() {
        Library library = new Library();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        Book book1 = new Book("title1", 2023, List.of(new Person[]{new Person("name1", "surname1")}));
        Book book2 = new Book("title2", 2023, List.of(new Person[]{new Person("name2", "surname2")}));
        library.addBook(book1);
        library.addBook(book2);
        Optional<Book> book = library.getBookByTitle("someTitle");
        Assertions.assertTrue(book.isEmpty(), "Должен возвращаться нулевой объект при взятии книги из пустой библиотеки");
    }
    @Test
    public void testTakingBookWhichIsInLibrary() {
        Library library = new Library();
        LibraryUser user = new LibraryUser("Кирилл", "Насыров");
        UserController userController = new UserController();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        for (int i = 0; i < 2; ++i) {
            library.addBook(new Book("Приключения Тома Сойера", 1876, List.of(new Person[]{new Person("Марк", "Твен")})));
        }
        for (int i = 0; i < 4; ++i) {
            library.addBook(new Book("Щегол", 2013, List.of(new Person[]{new Person("Донна", "Тарт")})));
        }
        Book book = new Book("Щегол", 2013, List.of(new Person[]{new Person("Донна", "Тарт")}));
        userController.get(library, user, "Щегол");
        Assertions.assertEquals(3, library.getBooksOfLibrary().get(book));
        Assertions.assertEquals(1, user.getBooksOfUser().get(book));
    }

    @Test
    public void testTakingBooksMoreThanWeCan() {
        Library library = new Library();
        LibraryUser user = new LibraryUser("Кирилл", "Насыров");
        UserController userController = new UserController();
        Assertions.assertEquals(0, library.getBooksOfLibrary().size());
        for (int i = 0; i < 2; ++i) {
            library.addBook(new Book("Приключения Тома Сойера", 1876, List.of(new Person[]{new Person("Марк", "Твен")})));
        }
        for (int i = 0; i < 4; ++i) {
            library.addBook(new Book("Щегол", 2013, List.of(new Person[]{new Person("Донна", "Тарт")})));
        }
        Book book = new Book("Приключения Тома Сойера", 1876, List.of(new Person[]{new Person("Марк", "Твен")}));
        userController.get(library, user, "Приключения Тома Сойера");
        userController.get(library, user, "Приключения Тома Сойера");
        userController.get(library, user, "Приключения Тома Сойера");
        Assertions.assertEquals(0, library.getBooksOfLibrary().get(book));
        Assertions.assertEquals(2, user.getBooksOfUser().get(book));
    }
}