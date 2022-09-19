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
 * Class: Transaction
 *
 * Description:
 *
 *
 ****************************************
 */

package lab06;

public class Transaction {
    /** stores the amount of items within the transaction*/
    private int numItems;

    /** stores how much the transaction will cost (for the customer)*/
    private double totalCost;

    /**
     * Transaction constructor class: sets numItems and TotalCost to 0
     */
    public Transaction() {
        this.numItems = 0;
        this.totalCost = 0;
    }

    /**
     * increments the numItems count and adds the item price to the total
     * @param price
     */
    public void addItem(double price) {
        this.numItems++;
        this.totalCost += price;
    }

    /**
     * creates a readable string for the Transaction
     * @return
     */
    public String toString() {
        return "default";
    }
    public int getNumItems() { return this.numItems; }

    public double getTotalCost() { return this.totalCost; }

}
