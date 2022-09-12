/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 9/11/22* Time: 9:20 PM
 *
 * Project: csci205_labs
 * Package: lab05
 * Class: BadCoder
 *
 * Description:
 *
 *
 ****************************************
 */

package lab05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BadCoder {

    public static final int NUM_INTS = 10;

    public static void main(String[] args) {
        //Great the user and ask for a name
        Scanner scnr = new Scanner(System.in);
        System.out.println("Greetings. What is your name?");
        String name = scnr.next();

        // Let's fill up an array with random integers
        Random rand = new Random();
        int[] x = new int[NUM_INTS];
        for (int i = 0; i <= NUM_INTS; i++) {
            x[i] = rand.nextInt(100);
        }
        System.out.println(name+", our array is: "+ Arrays.toString(x));
    }
}
