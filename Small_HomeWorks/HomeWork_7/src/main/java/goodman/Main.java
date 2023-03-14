package goodman;

import goodman.controllers.UserController;
import goodman.models.Book;
import goodman.models.Library;
import goodman.models.LibraryUser;
import goodman.models.Person;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        for (int i = 0; i < 3; ++i) {
            myLibrary.addBook(new Book("Джордан Хэндерсон: Автобиография", 2022, List.of(new Person[]{new Person("Джордан", "Хэндерсон")})));
        }
        for (int i = 0; i < 2; ++i) {
            myLibrary.addBook(new Book("Приключения Тома Сойера", 1876, List.of(new Person[]{new Person("Марк", "Твен")})));
        }
        for (int i = 0; i < 4; ++i) {
            myLibrary.addBook(new Book("Щегол", 2013, List.of(new Person[]{new Person("Донна", "Тарт")})));
        }
        for (int i = 0; i < 5; ++i) {
            myLibrary.addBook(new Book("Террор", 2007, List.of(new Person[]{new Person("Дэн", "Симмонс")})));
        }
        for (int i = 0; i < 8; ++i) {
            myLibrary.addBook(new Book("над пропастью во ржи", 1951, List.of(new Person[]{new Person("Джером", "Сэлинджер")})));
        }
        myLibrary.addBook(new Book("Террор", 2023, List.of(new Person[]{new Person("Насыров", "Кирилл")})));
        LibraryUser libraryUser = new LibraryUser("Кирилл", "Насыров");
        UserController userController = new UserController();
        userController.startProcess(myLibrary, libraryUser);
    }
}