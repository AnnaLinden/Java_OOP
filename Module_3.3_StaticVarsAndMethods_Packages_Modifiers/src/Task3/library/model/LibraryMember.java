package Task2.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        System.out.println("Created member: " + this.name + " (ID: " + this.memberId + ")");
    }

    // method to borrow a book
    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
        System.out.println(this.name + " borrowed " + book.getTitle());
    }

    // method to return a book
    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
        System.out.println(this.name + " returned " + book.getTitle());
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
