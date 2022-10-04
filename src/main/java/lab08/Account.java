/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 9/30/22* Time: 11:57 AM
 *
 * Project: csci205_labs
 * Package: lab08
 * Class: Account
 *
 * Description:
 *
 *
 ****************************************
 */

package lab08;

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
public class Account{

    private double balance;

    private Payable lastPayee;

    private double lastAmountPaid;

    public Account(double initBalance) {
        this.balance = initBalance;
        this.lastPayee = null;
        this.lastAmountPaid = 0;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) throws InsufficientFundsException {
        if(this.balance-amount<0) {
            throw new InsufficientFundsException("THE ACCOUNT DOES NOT HAVE ENOUGH MONEY FOR DEBIT");

        }
        this.balance-=amount;
    }

    public void processPayment(Payable payee, double hoursBilled) throws InsufficientFundsException {
        double moneyOwed = payee.calculatePay(hoursBilled);
        if (moneyOwed > 0.0) {
            this.lastAmountPaid = moneyOwed;
            this.lastPayee = payee;
            debit(moneyOwed);
        }
    }

    public double getCheckAmount() {
        return this.lastAmountPaid;
    }

    public String writeCheck() {
        double hrs;
        String s="";
        s+= "Pay to:       " + lastPayee.getPayTo()+"\n";
        s+= "Pay memo:     " + lastPayee.getPayMemo()+"\n";
        s+= "Pay amount:  $" + lastPayee.calculatePay(hrs = 40)+"\n";
        return s;
    }
}
