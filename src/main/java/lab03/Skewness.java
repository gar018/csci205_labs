/* *****************************************
*CSCI205 -Software Engineering and Design* Fall 2022
* Instructor: Prof. King
* Section: 01 - 9:00-9:50AM
*
* Name: Gordon Rose
* Date: 9/5/2022
* Lab / Assignment: lab03
*
* Description: generating skewed data and calculation mean and median
*
* *****************************************/

package lab03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


 /**
  * A simple enumerated type to help distinguish between skew types that the user 
  * might specify.
  */
enum SkewType {
    SKEW_LEFT,
    SKEW_RIGHT,
    SKEW_NONE
}

/** 
 * A class that encapsulate some methods to aid in generating a simulated dataset with
 * a specified skew, then reporting the results to see if the RNG really did properly
 * skew the data.
 */
public class Skewness {
    /** mean of data to be generate */
    public static final double DEF_MEAN = 10.0;

    /** stdev of data to be generated */
    public static final double DEF_STDEV = 2.0;

    /** Scanner to use for input */
    private static Scanner scnr;

    /**
     * This is an example main program you may use to complete this assignment.
     * 
     * @param args
     */
    public static void main(String[] args) {

        scnr = new Scanner(System.in);

        //request input for data
        int dataPoints = 0;
        boolean valid = false;
        do {
            System.out.print("How many data points would you like to generate?: ");
            if (scnr.hasNextInt()) {
                dataPoints = scnr.nextInt();
                if (dataPoints > 0) {
                    valid = true;
                }
            }
            scnr.nextLine();
        } while (!valid);
        valid = false;
        SkewType skew = SkewType.SKEW_NONE;
        do {
            System.out.print("How would you like the data to trend? (SKEW LEFT, SKEW RIGHT, NO SKEW): ");
            String skewInput = scnr.nextLine();
            if (skewInput.toLowerCase().contains("no")) {
                skew = SkewType.SKEW_NONE;
                valid = true;
            }
            else if (skewInput.toLowerCase().contains("left")) {
                skew = SkewType.SKEW_LEFT;
                valid = true;
            }
            else if (skewInput.toLowerCase().contains("right")) {
                skew = SkewType.SKEW_RIGHT;
                valid = true;
            }
        } while(!valid);

        //generate data based on skew
        double[] dataSet = new double[dataPoints];
        dataSet=generateSkewedData(dataPoints,skew);

        //calculate mean, median, and visible skew
        double mean = calcMean(dataSet);
        double median = calcMedian(dataSet);
        System.out.printf("MEAN: %.3f%n",mean);
        System.out.printf("MEDIAN: %.3f%n",median);
        System.out.println("VISIBLE SKEW?: "+findSkew(mean,median));
    }
    //STUDENT-MADE METHODS-=-=-=-=-=-=-

    public static double calcMean(double[] data){
        int mean = 0;
        for (double x : data) {
            mean+=x;
        }
        return (double)mean/data.length;
    }
    public static double calcMedian(double[] data){
        Arrays.sort(data);
        double median = 0;
        if (data.length%2==0){
            median=(data[data.length/2]+data[data.length/2-1])/2.0;
        }
        else {
            median=(data[data.length/2]);
        }
        return median;
    }
    public static String findSkew(double mean,double median) {
        double skewFactor = Math.abs((mean - median)/mean);
        if (skewFactor > .01){
            if (mean>median) {
                return "RIGHT";
            }
            else if(mean<median) {
                return "LEFT";
            }
        }
        return "NONE";
    }
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    /**
     * Create and initialize an array of <code>size</code> with
     * random integers between 0 and <code>MAX_INT</code> inclusive.
     *
     * @param sizeOfArray the size of the array to fill
     * @param skewType the specified {@link SkewType} 
     * @return an int array of size random numbers between 0 and MAX_INT
     */
    public static double[] generateSkewedData(int sizeOfArray, SkewType skewType) {
        double[] result = new double[sizeOfArray];

        Random rng = new Random(1000);

        // Fill in the array of random integers
        for (int i = 0; i < sizeOfArray; i++) {
            result[i] = rng.nextGaussian() * DEF_STDEV + DEF_MEAN;
        }

        // Let's create some intentional skew in our data if requested
        for(int i = 0; i < sizeOfArray/20; i++) {
            switch (skewType) {
                case SKEW_LEFT:
                    result[i] = (rng.nextGaussian() * DEF_STDEV + DEF_MEAN) * 0.25;
                    break;
                case SKEW_RIGHT:
                    result[i] = (rng.nextGaussian() * DEF_STDEV + DEF_MEAN) * 4;
                    break;
            }
        }

        return result;
    }

}
