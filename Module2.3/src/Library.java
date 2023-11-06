import java.sql.Array;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    // add the given Book object to the library's collection.
    public void addBook(Book book) {
        books.add(book);
    }

    // display the details of all books in the library's collection,
    // including their titles, authors, and publication years.
    public void displayBooks() {
        System.out.println("Library Catalog:");

        for (Book book : books) {
            int i = 1;
            System.out.println(
                    i + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
            i++;
        }
    }

    // search and display the details of books written by the specified author.
    public void findBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book.getTitle() + ", " + book.getAuthor() + ", " + book.getYear());
            }
        }
    }
}
