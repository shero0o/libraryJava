package packages;

import java.util.ArrayList;
import java.util.Map;

public class Member {

    private String name;
    private String returnBook;
    Library library = new Library();

    public Member(
            String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void listLoanedBooks(Library library) {
        boolean hasLoanedBooks = false;
        for (Map.Entry<String, Member> entry : library.loanedBooks.entrySet()) {
            String bookTitle = entry.getKey();
            Member member = entry.getValue();
            if (member == this) {
                System.out.println(member.getName() + " hat folgende Bücher ausgeliehen: " + bookTitle);
                hasLoanedBooks = true;
            }
        }
        if (hasLoanedBooks == false) {
            System.out.println(name + " hat keine Bücher ausgeliehen.");
        }
    }

    public void returnLoanedBook(String returnBook) {
        boolean bookReturned = false;
        for (Map.Entry<String, Member> entry : library.loanedBooks.entrySet()) {
            if (entry.getKey().equals(returnBook)) {
                library.loanedBooks.remove(returnBook);
                bookReturned = true;
                System.out.println("Das Buch '" + returnBook + "' wurde erfolgreich zurückgegeben.");
                break; // Wir haben das Buch gefunden und entfernt, also brechen wir die Schleife ab
            }
        }
        if (bookReturned==false) {
            System.out.println("Das Buch '" + returnBook + "' wurde nicht ausgeliehen oder ist bereits zurückgegeben worden.");
        }
    }
    

}
