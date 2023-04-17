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


public abstract class Loan implements LoanConstants {
    protected int loanNumber;
    protected String name;
    protected double amount;
    protected double rate;
    protected int term;

    public Loan(int loanNumber, String name, double amount, int term) {
        this.loanNumber = loanNumber;
        this.name = name;
        this.setAmount(amount);
        this.setTerm(term);
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        if (amount > LoanConstants.MAX_AMOUNT)
            this.amount = LoanConstants.MAX_AMOUNT;
        else 
            this.amount = amount;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setTerm(int term) {
        if (term != LoanConstants.MEDIUM_TERM && term != LoanConstants.LONG_TERM)
            this.term = LoanConstants.SHORT_TERM;
        else
            this.term = term;
    }

    public double calcTotal() {
        return amount + ((amount / 100) * rate * term); 
    }
    
    @Override
    public String toString() {
        return "Loan No.: " + loanNumber + "\tName: " + name + "\nAmount: $" + amount + "\tRate: " + rate + "%\tTerm: " + term + " years";
    }
}
