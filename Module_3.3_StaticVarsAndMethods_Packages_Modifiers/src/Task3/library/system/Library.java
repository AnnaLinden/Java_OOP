package Task3.library.system;

import Task3.library.model.Book;
import Task3.library.model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
        } else {
            System.out.println(
                    member.getName() + " tried to reserve " + book.getTitle() + " but it is already reserved.");
        }

    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not reserved by this member.");
        }
    }

}
