package Task2.library.system;

import Task2.library.model.Book;
import Task2.library.model.LibraryMember;
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

    // borrow and return methods
    public void borrowBook(LibraryMember member, Book book) {
        member.borrowBook(book);
    }

    public void returnBook(LibraryMember member, Book book) {
        member.returnBook(book);
    }

}
