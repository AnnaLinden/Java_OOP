import java.util.ArrayList;

public class LibraryMain {
    /*
     * Create instances of Book representing different books.
     * Create an instance of Library.
     * Add the book instances to the library.
     * Display the list of all books in the library.
     * Search for books by a specific author and display the results.
     */

    /*
     * Library Catalog:
     * 1. Title: "Introduction to Java Programming", Author: "John Smith", Year:
     * 2020
     * 2. Title: "Data Structures and Algorithms", Author: "Jane Doe", Year: 2018
     * 3. Title: "The Art of Fiction", Author: "Alice Johnson", Year: 2019
     * 
     * Books by Author "Jane Doe":
     * Title: "Data Structures and Algorithms", Year: 2018
     */

    public static void main(String[] args) {
        // Create instances of Book representing different books.
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Set ratings for the books
        book1.setRating(4.5);
        book2.setRating(4.0);
        book3.setRating(4.8);

        // Add reviews to the books
        book1.addReview("Very informative and well-structured.");
        book1.addReview("Excellent for beginners.");
        book2.addReview("Comprehensive and concise.");

        // Create an instance of Library.
        Library library = new Library();

        // Add the book instances to the library.
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display the list of all books in the library.
        library.displayBooks();

        // Search for books by a specific author and display the results.
        library.findBookByAuthor("Jane Doe");

        // Borrow a book
        // library.borrowBook("Data Structures and Algorithms");
        // library.displayBooks();

        // is available
        // System.out.println(library.isBookAvailable("Data Structures and
        // Algorithms"));

        // set rating
        book1.setRating(4.5);
        System.out.println(book1.getRating());

        // add review
        book1.addReview("This book is awesome!");

        // get reviews
        System.out.println(book1.getReviews());

        // Test the getAverageBookRating method
        double averageRating = library.getAverageBookRating();
        System.out.println("Average Book Rating: " + averageRating);

        // Test the getMostReviewedBook method
        Book mostReviewedBook = library.getMostReviewedBook();
        System.out.println("Most Reviewed Book: " + mostReviewedBook.getTitle() +
                " with " + mostReviewedBook.getReviews().size() + " reviews.");

        // Create users
        User user1 = new User("Alice", 25, new ArrayList<>());
        User user2 = new User("Bob", 30, new ArrayList<>());

        // Add users to the library
        library.addUser(user1);
        library.addUser(user2);

        // User 1 borrows a book
        library.borrowBook("Introduction to Java Programming", "Alice");
        library.borrowBook("Data Structures and Algorithms", "Bob");

        // Check if the book is available after borrowing
        System.out.println("Is 'Introduction to Java Programming' available? " +
                library.isBookAvailable("Introduction to Java Programming"));

        // User 1 returns a book
        library.returnBook(book1, "Alice");

        // Check again if the book is available after returning
        System.out.println("Is 'Introduction to Java Programming' available after returning? " +
                library.isBookAvailable("Introduction to Java Programming"));
    }

}
