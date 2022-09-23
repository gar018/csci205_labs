/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: Gordon Rose
 * Date: 9/22/22
 * Time: 6:00 PM
 *
 * Project: csci205_labs
 * Package: lab07
 * Class: ExceptionExample
 * Description:
 *
 * ****************************************
 */

package lab07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] x = new int[SIZE];
        int i = 0;

        do {
            try {
                System.out.print("Enter an index to fill, or " + SIZE + " to finish: ");
                i = scnr.nextInt();
                if (i != SIZE)
                    x[i] = i;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(i + " is out of range! Try again!");
            }
            catch (InputMismatchException e) {
                System.out.println("Please input integers! Try again!");
                scnr.nextLine();
            }
        } while (i != SIZE);
    }

}
