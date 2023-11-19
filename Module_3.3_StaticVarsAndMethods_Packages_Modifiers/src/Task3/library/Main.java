package Task3.library;

import Task3.library.model.Book;
import Task3.library.model.LibraryMember;
import Task3.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Lord of the Rings", "J. R. R. Tolkien", "978-0261103252");
        Book book2 = new Book("The Hobbit", "J. R. R. Tolkien", "978-0261103283");
        Book book3 = new Book("The Silmarillion", "J. R. R. Tolkien", "978-0261102736");

        LibraryMember member1 = new LibraryMember("John Doe", 1);
        LibraryMember member2 = new LibraryMember("Wille Wonka", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member1);
        library.addMember(member2);

        library.reserveBook(member1, book1);
        library.reserveBook(member1, book2);
        library.reserveBook(member2, book1);
        library.reserveBook(member2, book3);

        library.cancelReservation(member1, book1);
        library.cancelReservation(member1, book2);
        library.cancelReservation(member2, book1);
        library.cancelReservation(member2, book3);

    }

}
