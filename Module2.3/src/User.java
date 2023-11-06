import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks;

    public User(String name, int age, ArrayList<Book> borrowedBooks) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<Book>();
    }

    // borrow books
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println("You have borrowed " + book.getTitle());
    }

    // return books
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println("You have returned " + book.getTitle());
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
