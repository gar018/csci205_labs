package lab08;

/**
 * Implements the Payable interface
 * any class that implements this interface act as payable objects, and have methods that are able
 * to interact with their payment
 */
public interface Payable {

    /**
     * calculates the amount of pay necessary for the Payable obj
     * @param numHrs
     * @return totalPayment
     */
    public double calculatePay(double numHrs);

    /**
     * returns the name String of who the pay is given to
     * @return name
     */
    public String getPayTo();

    /**
     * adds additional information to transaction (String)
     * @return memo
     */
    public String getPayMemo();

}
