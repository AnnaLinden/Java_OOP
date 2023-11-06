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
        int i = 1;
        for (Book book : books) {

            System.out.println(
                    i + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
            i++;
        }
    }

    // search and display the details of books written by the specified author.
    public void findBookByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: " + book.getTitle() + ", Year: " + book.getYear());
            }
        }
    }

    // borrowBook(String title): This method should simulate a book being borrowed.
    // It should remove the book from the library's collection if available.
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                System.out.println("You have borrowed " + title);
                return;
            }
        }
        System.out.println("Sorry, " + title + " is not available");
    }

    // returnBook(Book book): This method should simulate a book being returned
    // to the library. It should add the book back to the library's collection.
    public void returnBook(Book book) {
        books.add(book);
        System.out.println("You have returned " + book.getTitle());
    }

    // Add a method to the Library class to check the availability of a specific
    // book by its title:
    // isBookAvailable(String title): This method should return a boolean indicating
    // whether the book with the specified title is available in the library.

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

}
