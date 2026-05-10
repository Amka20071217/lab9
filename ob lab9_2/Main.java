import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Book {
    String title;
    int year;

    Book(String title, int year) {
        this.title = title;
        this.year = year;
    }
}

class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    class BookShelf implements Iterable<Book> {

        private int minYear;

        BookShelf(int minYear) {
            this.minYear = minYear;
        }

        public Iterator<Book> iterator() {

            List<Book> filtered = new ArrayList<>();

            for (Book b : books) {
                if (b.year >= minYear) {
                    filtered.add(b);
                }
            }

            return filtered.iterator();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook(new Book("Suun Zam", 2020));
        lib.addBook(new Book("Old Book", 1990));

        Library.BookShelf shelf = lib.new BookShelf(2000);

        for (Book b : shelf) {
            System.out.println(b.title + ": " + b.year);
        }
    }
}