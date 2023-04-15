package goodman.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private final String title;
    private final int year;
    private final List<Person> authors;

    public Book(String title, int year, List<Person> authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<Person> getAuthors() {
        return new ArrayList<>(authors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, authors);
    }

    @Override
    public String toString() {
        return "Книга: " + title + "; год: " + year + "; авторы: " + authors;
    }
}
