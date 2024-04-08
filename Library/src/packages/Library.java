package packages;

import packages.Books;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    HashMap<Integer, String> bookCollection = new HashMap<Integer, String>();
    HashMap<String, Member> loanedBooks = new HashMap<String, Member>();
    ArrayList<String> member = new ArrayList<String>();
    private Integer isbn;
    private String title;
    private String memberName;
    // Books book1 = new Books("Buch10", 123456);
    // Books book2 = new Books("Buch9", 4545);

    // public Library() {
    //     // addBook(Books book);
    //     // removeBook();
    //     // findBook(isbn, title);
    //     //addMember();
    //     findMember(memberName);
    // }

    public void addBook(Books book) {
        bookCollection.put(book.getIsbn(), book.getTitle());

    }

    public void removeBook(Books book) {
        bookCollection.remove(book.getIsbn());
    }

    public boolean findBook(Books book) {
        for (Map.Entry<Integer, String> entry : bookCollection.entrySet()) {
            if (entry.getValue().equals(book.getTitle()) && entry.getKey().equals(book.getIsbn())) {
                // return "Das Buch \"" + book.getTitle() + "\" wurde gefunden.";
                return true;
            }
        }

        // return "Das Buch \"" + title + "\" wurde nicht gefunden.";
        return false;
    }

    public void addMember(String memberName) {
    member.add(memberName);
    }

    public void findMember(String memberName) {
        for (int i = 0; i < member.size(); i++) {
            if (memberName == member.get(i)) {
                System.err.println(memberName + " ist Mitglied bei uns!");
            }
        }
    }

    public void listAllMembers() {
        for (int i = 0; i < member.size(); i++) {
            System.out.println(member.get(i));
        }
    }

}
