package Task3.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> reservedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.reservedBooks = new ArrayList<>();
        System.out.println("Created member: " + this.name + " (ID: " + this.memberId + ")");
    }

    // method to reserve a book
    public void addReservedBook(Book book) {
        reservedBooks.add(book);
        System.out.println(this.name + " reserved " + book.getTitle() + "from addReservedBook method");
    }

    // method to remove reservation
    public void removeReservedBook(Book book) {
        reservedBooks.remove(book);
        System.out.println(this.name + " cancelled reservation of  " + book.getTitle());
    }

    public boolean hasReservedBook(Book book) {
        return reservedBooks.contains(book);
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

}
