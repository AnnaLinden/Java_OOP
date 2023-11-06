import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();

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

    // Add a user to the library
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    // Modify the borrowBook method to require a user's name
    public void borrowBook(String title, String userName) {
        User user = users.get(userName);
        if (user == null) {
            System.out.println("User does not exist in the library system.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                user.borrowBook(book);
                System.out.println(userName + " has borrowed " + title);
                return;
            }
        }
        System.out.println("Sorry, " + title + " is not available");
    }

    // Method to return a book to the library
    public void returnBook(Book book, String userName) {
        User user = users.get(userName);
        if (user != null && user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            books.add(book);
            System.out.println(userName + " has returned " + book.getTitle());
        } else {
            System.out.println("This book does not belong to " + userName);
        }
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

    // Method to calculate the average book rating
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0; // Handle case with no books
        }

        double totalRating = 0.0;
        int ratedBooksCount = 0;

        for (Book book : books) {
            if (book.getRating() > 0) { // Assuming unrated books have a rating of 0
                totalRating += book.getRating();
                ratedBooksCount++;
            }
        }

        return ratedBooksCount > 0 ? totalRating / ratedBooksCount : 0.0;
    }

    // Method to find the most reviewed book
    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null; // Handle case with no books
        }

        Book mostReviewedBook = books.get(0);
        for (Book book : books) {
            if (book.getReviews().size() > mostReviewedBook.getReviews().size()) {
                mostReviewedBook = book;
            }
        }

        return mostReviewedBook;
    }

}
