import packages.*;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Library library = new Library();
        Books book1 = new Books("Buch10", 123456, false, library);
        Books book2 = new Books("Buch11", 1234567, false, library);
        Member member1 = new Member("mervan");
        Member member2 = new Member("kousa");

        library.addBook(book1);
        library.addBook(book2);

        boolean foundBook = library.findBook(book1);
        if (foundBook) {
            System.out.println("Das Buch " + book1.getTitle() + " wurde gefunden!");
        }

        boolean ausgeliehen = book1.checkOut();
        if (ausgeliehen) {
            System.out.println("Das Buch " + book1.getTitle() + " ist ausgeliehen");
        } else {
            System.out.println("Das Buch " + book1.getTitle() + " ist verfügbar!");
        }

        String borrowBook1 = book1.borrow(member1);
        System.out.println(borrowBook1);
        String borrowBook2 = book2.borrow(member2);
        System.out.println(borrowBook2);
        String borrowBook3 = book2.borrow(member1);
        System.out.println(borrowBook3);

        library.addMember("daniel");
        library.addMember("niklas");
        library.addMember("shiyar");
        library.listAllMembers();
        library.findMember("shiyar");

        member2.listLoanedBooks(library);
        member1.listLoanedBooks(library);

        member2.returnLoanedBook("Buch11");

    }
}
