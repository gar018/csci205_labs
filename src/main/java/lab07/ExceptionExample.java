/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: YOUR NAME
 * Date: 9/18/22
 * Time: 10:00 AM
 *
 * Project: csci205_labs
 * Package: lab07
 * Class: ExceptionExample
 * Description:
 *
 * ****************************************
 */

package lab07;

import java.util.Scanner;

public class ExceptionExample {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] x = new int[SIZE];
        int i = 0;

        do {
            System.out.print("Enter an index to fill, or " + SIZE + " to finish: ");
            i = scnr.nextInt();
            if (i != SIZE)
                x[i] = i;
        } while (i != SIZE);
    }

}
