/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 9/9/22* Time: 9:15 PM
 *
 * Project: csci205_labs
 * Package: lab04
 * Class: HelloIntelliJ
 *
 * Description:
 *
 *
 ****************************************
 */

package lab04;

import java.util.Scanner;

/**
 * A simple program to help us become familiar with IntelliJ
 *
 * @author Gordon Rose*/
public class HelloIntelliJ {

    private static String sFirst;
    private static String sLast;
    private static String sFullName;

    /**
     * our main program, asks the user for their first and last name, than performs a vowel analysis
     * @param args command line arguments supplied to the program
     * */
    public static void main(String[] args) {
        // TODO finish main method
        Scanner scnr = new Scanner(System.in);
        askUserForName(scnr);
        int vowels = getVowels();
        printResults(vowels);

    }

    /**
     * prints results of our vowel analysis {@link System#out}
     * @param vowels the number of vowels found in first and last name
     */
    private static void printResults(int vowels) {
        int len = sFullName.length();
        double perc = (double) vowels /len*100.0;
        System.out.printf("You have %d letters in your name.%n", len);
        System.out.printf("You have %d vowels.%n", vowels);
        System.out.printf("%.1f%% of your name consists of vowels.%n",perc);
    }

    /**
     * Count the number of vowels that was entered
     * @return the number of vowels in the first and last name
     */
    private static int getVowels() {
        int vowels = 0;
        for (char ch : sFullName.toLowerCase().toCharArray()){
            switch (ch){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowels++;
                    break;
            }
        }
        return vowels;
    }

    /**
     * asks user input for first {@link #sFirst} and last {@link #sLast}name
     * @param scnr supplies the method with the Scanner class
     */
    private static void askUserForName(Scanner scnr) {
        //ask the user for first name
        System.out.println("Please enter your first name: ");
        sFirst = scnr.nextLine().strip();

        //ask the use for their last name
        System.out.println("Now, enter your last name: ");
        sLast = scnr.nextLine().strip();

        sFullName = sFirst +" "+ sLast;
        System.out.println("Your full name is: "+ sFullName);
    }
}
