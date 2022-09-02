/* *****************************************
*CSCI205 -Software Engineering and Design* Fall 2022
* Instructor: Prof. King
* Section: 01 - 9:00-9:50AM
*
* Name: Gordon Rose
* Date: 08/31/2002
* Lab / Assignment: lab02
*
* Description: Understanding precision and computation time of primitive vs wrapped objects using fibonacci
*
* *****************************************/

package lab02;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * A simple class designed to give the user an opportunity to test a recursive
 * and non-recursive version of fibonacci, as well as using BigInteger so you
 * can
 * compute very large values
 *
 * @author BRK 2022-fall
 */
public class Fibonacci {

    /**
     * Compute the nth fibonacci number recursively
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int recFib(int n) {
        if (n==1) {
            return 1;
        }
        else if (n==0) {
            return 0;
        }
        else {
            return recFib(n-1) + recFib(n-2);
        }
    }

    /**
     * Compute the nth fibonacci number non-recursively, using a while loop.
     *
     * @param n - the nth number to find
     * @return the nth number in the fibonacci sequence
     */
    public static int nonRecFib(int n) {
        int m = 1;
        int curValue = 1;
        int prevValue = 0;
        while (m<n){
            int nextValue = curValue+prevValue;
            prevValue = curValue;
            curValue = nextValue;
            m++;
        }
        return curValue;
    }

    /**
     * Compute the nth fibonacci number non-recursively, using BigInteger.
     * 
     * @param n    - the nth number to find
     * 
     * @param args
     */
    public static BigInteger nonRecFibBigInteger(int n) {
        int m = 1;
        BigInteger CURVALUE = BigInteger.ONE;
        BigInteger PREVVALUE = BigInteger.ZERO;
        while (m<n) {
            BigInteger NEXTVALUE = CURVALUE.add(PREVVALUE);
            PREVVALUE = CURVALUE;
            CURVALUE = NEXTVALUE;
            m++;
        }
        return CURVALUE;
    }

    /**
     * Main program to test all fibonacci methods
     */
    public static void main(String[] args) {
        final int MAX_RECURSIVE_N = 40;

        System.out.println("Fibonacci number to compute:");
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        long startTime;
        long elapsedNanos;
        double elapsedTimeRec = 0;
        // Store the result from the different ways to compute fib(n)
        int recResult = 0;
        if (n <= MAX_RECURSIVE_N) {
            startTime = System.nanoTime();
            recResult = recFib(n);
            elapsedNanos = System.nanoTime() - startTime;
            elapsedTimeRec = (double)elapsedNanos*1E-6;
        }

        startTime = System.nanoTime();
        int nonRecResult = nonRecFib(n);
        elapsedNanos = System.nanoTime() - startTime;
        double elapsedTimeNonRec = (double)elapsedNanos*1E-6;

        startTime = System.nanoTime();
        BigInteger nonRecFibBigIntegerResult = nonRecFibBigInteger(n);
        elapsedNanos = System.nanoTime() - startTime;
        double elapsedTimeNonRecBig = (double)elapsedNanos*1E-6;

        // Print the results
        if (n <= MAX_RECURSIVE_N) {
            System.out.print("Recursive fib: " + recResult);
            System.out.printf(" Time: %.4f ms%n",elapsedTimeRec);
        } 
        else {
            System.out.println("Recursive fib: COULD NOT COMPUTE");
        }
        
        System.out.print("Non-recursive fib: " + nonRecResult);
        System.out.printf(" Time: %.4f ms%n",elapsedTimeNonRec);
        System.out.print("Non-recursive fib with BigInteger: " + nonRecFibBigIntegerResult);
        System.out.printf(" Time: %.4f ms%n",elapsedTimeNonRecBig);
    }

}
