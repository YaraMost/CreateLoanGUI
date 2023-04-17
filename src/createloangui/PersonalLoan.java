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


public class PersonalLoan extends Loan{
    public PersonalLoan(int loanNumber, String name, double amount, int term, double rate) {
        super(loanNumber, name, amount, term);
        super.setRate(rate + (rate / 50));
    }
    
    @Override
    public String toString() {
        return "Personal Loan\n" + super.toString();
    }
}
