/**
 * Name: Yara Most
 * Class: Object Oriented Programming 
 * Date: 04/02/2023
 * Homework 10 - Java GUI
 * Description: this program uses JavaFX to have the user input loan information
 *              then creates an arrayList with all the loans entered and display them
 *              in a new window.
 */
package createloangui;


public class BusinessLoan extends Loan {
    public BusinessLoan(int loanNumber, String name, double amount, int term, double rate) {
        super(loanNumber, name, amount, term);
        super.setRate(rate + (rate/100));
    }

    @Override
    public String toString() {
        return "Business Loan\n" + super.toString();
    }
}
