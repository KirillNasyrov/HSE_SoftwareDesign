package goodman.view;

import goodman.models.Book;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleHandler {
    Scanner scanner;
    public ConsoleHandler() {
        scanner = new Scanner(System.in);
    }
    public void printBooks(List<Book> books) {
        int counter = 1;
        for (Book book : books) {
            System.out.println(counter + ") " + book);
            ++counter;
        }
    }

    public void printBooks(Map<Book, Integer> books) {
        int counter = 1;
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(counter + ") " + entry.getKey() + "; количество: " + entry.getValue());
                ++counter;
            }
        }
    }

    public void printNoBooksMessage() {
        System.out.println("No books with such title");
    }

    public int chooseTheBook(int numberOfBooks) {
        System.out.print("write out index of book: ");
        int index = scanner.nextInt();
        while (index < 1 || index > numberOfBooks) {
            System.out.println("invalid number of book");
            System.out.print("write out index of book: ");
            index = scanner.nextInt();
        }
        return index - 1;
    }

    public String[] getCommand() {
        System.out.print("Write out command: ");
        return scanner.nextLine().split(" ", 2);
    }
}
