package packages;

import java.util.Map;

import packages.*;

public class Books {

    private String title;
    private Integer isbn;
    private boolean loanedStatus;
    private Library library;
    private Member membersValue;

    public Books(String title, Integer isbn, boolean loanedStatus, Library library) {
        this.title = title;
        this.isbn = isbn;
        this.loanedStatus = loanedStatus;
        this.library = library;
        this.membersValue = new Member("");

    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getLoanedStatus() {
        return loanedStatus;
    }

    public void loanedTo() {

    }

    public boolean checkOut() {
        boolean foundBOOK = library.findBook(this);
        if (foundBOOK == true) {
            if (loanedStatus == true) {

                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String borrow(Member membersValue) {
        if (checkOut()) {
            return "Das Buch " + getTitle() + " ist bereits von "+ this.membersValue.getName()+" ausgeliehen und kann deswegen nicht ausgeliehen werden";
        } else {
            this.loanedStatus = true;
            this.membersValue = membersValue; 
            library.loanedBooks.put(getTitle(), membersValue);
            return "Das Buch " + getTitle() + " wurde erfolgreich von " + membersValue.getName() + " ausgeliehen!";
        }

    }

}
