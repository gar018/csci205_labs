/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: YOUR NAME
 * Date: 9/7/22
 * Time: 3:51 PM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: Fraction
 * Description:
 * A class that represent a Fraction of int values.
 * It also provides a collection of basic math operations
 * ****************************************
 */

package lab05;

/**
 * This class encapsulates a single fraction in the form of
 * x/y, where x and y are restricted to integers
 */
class Fraction {
    /** The numerator of the fraction */
    private final int numerator;

    /** The denominator of the fraction */
    private final int denominator;

    /** Is this fraction valid? A valid fraction must have both numbers set properly and
     * can not have a 0 in the denominator */
    private final boolean isValid;

    /**
     * Construct a new Fraction from two integer values. If the denominator
     * is zero, the fraction is not considered valid (@code isValid} is
     * {@code false}
     *
     * @param numerator an {@code int} numerator of the fraction
     * @param denominator an {@code int} denominator of the fraction
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (this.denominator==0){
            this.isValid=false;
        }
        else{
            this.isValid=true;
        }
        // if the denominator is not 0, fraction is valid

    }

    /**
     * Construct a new Fraction from a string in the form "a / b". There may or
     * may not be whitespace in between tokens in the string. If the string
     * could not be parsed, then set isValid to false and print an error message.
     * If it could be parsed, but the denominator is 0, just set isValid to false.
     * Otherwise isValid is true
     *
     * @param strFraction a String that should be of the form a/b. If there is
     *                    any problem parsing the fraction, then the fraction
     *                    defaults to 1/1 and a  message idisplayed
     */
    public Fraction(String strFraction) {
        int nume = 1;
        int denom = 1;
        boolean valid = true;
        // holds the index of where the / is located in the string input
        int backslashIndex=strFraction.indexOf("/");

        // if returns -1, then fraction doesnt contain /, meaning it's invalid
        if(backslashIndex == -1){
            valid=false;
        }
        else {
            try { //attempt to parse the numerator and denominator
                nume = Integer.parseInt(strFraction.substring(0, backslashIndex).strip());
                denom = Integer.parseInt(strFraction.substring(backslashIndex + 1).strip());
                if (denom == 0) {
                    valid = false;
                }
            }
            catch (NumberFormatException e){ //any problems print an error, and invalidate the fraction
                System.err.println("PARSING ERROR! - Please input a valid fraction!");
                nume=1;
                denom=1;
                valid=false;
            }
        }
        this.numerator=nume;
        this.denominator=denom;
        this.isValid=valid;
    }

    /** @return the numerator in the fraction */
    public int getNumerator() { return numerator; }

    /** @return the denominator in the fraction */
    public int getDenominator() { return denominator; }

    /** @return the state of the {@link #isValid} flag */
    public boolean isValid() { return this.isValid; }

    /**
     * Return a new copy of this fraction but in most simplified terms
     *
     * @return a new Fraction that represents this Fraction but in simplest terms.
     * For example, 3/6 would return a new Fraction 1/2. 1/2 would also return 1/2.
     */
    public Fraction getSimplifiedFraction() {
        //the lowest value between the numerator and the denominator
        int lowestValue = Math.min(this.numerator,this.denominator);

        //the greatest common factor -- starts at 1, and updates whenever a larger common factor is found
        int gcf = 1;

        for (int i = 1; i <= lowestValue; i++) {
            //if int and double division equal each other for both nume and denom, then they share a common factor!
            if (this.numerator/i==this.numerator/(double)i&&this.denominator/i==this.denominator/(double)i) {
                gcf = i;
            }
        }

        return new Fraction(this.numerator/gcf,this.denominator/gcf);
    }

    /**
     * @return a new Fraction representing the reciprocal of this fraction
     */
    public Fraction reciprocal() {
        return new Fraction(this.denominator,this.numerator);
    }

    /**
     * @return a new Fraction representing the negative of this fraction
     * (multiply the numerator or denominator by -1)
     */
    public Fraction negate() {
        return new Fraction(-1*this.numerator,this.denominator);
    }

    /**
     * @return this fraction as a single floating point number (e.g. 1/2 ==> 0.5)
     */
    public double getDecimal() {
        return (double)this.numerator/this.denominator;
    }

    /**
     * Perform simple Fraction addition, returning a new Fraction that represents
     * this added to {@code otherFrac} in simplified form
     *
     * @param otherFrac the other Fraction that will be added to this one
     * @return a new Fraction that represents the addition of this Fraction to
     *         otherFrac, simplified
     */
    public Fraction add(Fraction otherFrac) {
        Fraction frac1 = new Fraction(this.numerator*otherFrac.denominator, this.denominator*otherFrac.denominator);
        Fraction frac2 = new Fraction(otherFrac.numerator*this.denominator, otherFrac.denominator*this.denominator);
        return new Fraction(frac1.numerator+frac2.numerator,frac1.denominator).getSimplifiedFraction();
    }

    /**
     * @return the product of this fraction multiplied to {@code otherFrac}
     * as a new Fraction, simplified
     */
    public Fraction multiply(Fraction otherFrac) {
        //multiplies the numerators by each other, and the denominators, then simplifies
        return new Fraction(this.numerator*otherFrac.numerator,this.denominator*otherFrac.denominator).getSimplifiedFraction();
    }

    /**
     * Multiply this fraction with a specified numerator and denominator
     *
     * @param numerator the numerator to multiply to this numerator
     * @param denominator the denominator to multiple to this denominator
     *
     * @return a new Fraction that is this fraction multiplied by a provided
     * numerator and denominator, in simplified form
     */
    public Fraction multiply(int numerator, int denominator) {
        return new Fraction(this.numerator*numerator,this.denominator*denominator).getSimplifiedFraction();
    }

    /**
     * Is this fraction greater than {@code otherFrac}?
     *
     * @param otherFrac the other Fraction to compare to
     * @return true if this fraction is greater than {@code otherFrac}
     */
    public boolean isGreaterThan(Fraction otherFrac) {
        if (this.getDecimal()> otherFrac.getDecimal()){
            return true;
        }
        return false;
    }

    /**
     * Is this Fraction equal to {@code otherFrac}?
     * NOTE: 1/2 == 3/6 (i.e numerators do not need
     * to be the same)
     *
     * @return true if this fraction is equal to otherFrac,
     * false otherwise.
     */
    public boolean isEqualTo(Fraction otherFrac) {
        if (this.getDecimal()== otherFrac.getDecimal()){
            return true;
        }
        return false;
    }

    /**
     * @return a String in the form of x/y, where x is the numerator and
     *         y is the denominator.
     *         However:
     *         - if the numerator is 0, then return "0".
     *         - if the denominator is 0, then return "ERROR - divide by 0"
     *         - if the numerator == denominator, then return "1"
     *         - otherwise, return numerator/denominator
     */
    @Override
    public String toString() {
        //gather the numerator and denominator
        int x = this.getNumerator();
        int y = this.getDenominator();

        //determine whether to use special cases
        if (x==0) {
            return "0";
        }
        else if (y==0) {
            return "ERROR - divide by 0";
        }
        else if (x==y) {
            return "1";
        }
        //else just print a fraction!
        else {
            return x+"/"+y;
        }
    }
}
