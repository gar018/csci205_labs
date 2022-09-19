/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 9/18/22* Time: 10:52 PM
 *
 * Project: csci205_labs
 * Package: lab06
 * Class: CashRegister
 *
 * Description:
 *
 *
 ****************************************
 */

package lab06;

/** the states the register can be in*/
enum CashRegisterState{
    NOT_READY,  //register is not signed in for use
    READY, //register is signed in for use
    SCANNING, //register is processing a transaction
    RECEIVE_PMT //register is awaiting payment for transaction
}
public class CashRegister {

    /** name of the register*/
    private String registerName;

    /** amt of cash inside the register*/
    private double totalCash;

    /** how much money was received for a transaction*/
    private double paymentReceived;

    /** current transaction taking place*/
    private Transaction currentTransaction;

    /** the state the cash register is in*/
    private CashRegisterState state;

    /**
     * default constructor, initializes an empty register
     */
    public CashRegister() {
        this.registerName = "Default";
        this.totalCash = 0;
        this.paymentReceived = 0;
        this.state = CashRegisterState.NOT_READY;
        this.currentTransaction = null;
    }

    /**
     * constructor including a given register name
     */
    public CashRegister(String registerName) {
        this.registerName = registerName;
        this.totalCash = 0;
        this.paymentReceived = 0;
        this.state = CashRegisterState.NOT_READY;
        this.currentTransaction = null;
    }

    /** signs in the cashier,
     * initializes the current money in the register,
     * and sets register state to READY
     * @param initCash the cash currently in the register
     * @return true, false
     */
    public boolean signIn(double initCash) {
        if (this.state == CashRegisterState.NOT_READY) {
            this.totalCash = initCash;
            this.state = CashRegisterState.READY;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * signs out the cashier and changes register state back to NOT_READY
     * @return this.totalCash
     */
    public double signOut() {
        if (this.state == CashRegisterState.READY) {
            this.state = CashRegisterState.NOT_READY;
            return this.totalCash;
        }
        else {
            return 0;
        }
    }

    /**
     * scans an item and adds it to the transaction - if register is still READY,
     * it makes a new transaction and sets it to SCANNING
     * @param price
     * @return
     */
    public boolean scanItem(double price) {
        if (this.state == CashRegisterState.READY){
            this.state = CashRegisterState.SCANNING;
            this.currentTransaction = new Transaction();
            this.currentTransaction.addItem(price);
            return true;
        }
        else if(this.state == CashRegisterState.SCANNING) {
            this.currentTransaction.addItem(price);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * gets the amount owed from the transaction
     * @return
     */
    public double getAmountOwed() {
        if (this.state == CashRegisterState.SCANNING) {
            return this.currentTransaction.getTotalCost();
        }
        else {
            return 0;
        }
    }
/*
    public double collectPayment(double payment) {
        if (this.state == CashRegisterState.SCANNING) {
            this.state = CashRegisterState.RECEIVE_PMT;
        }
    }*/


}
