/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 9/9/22* Time: 10:47 PM
 *
 * Project: csci205_labs
 * Package: lab04
 * Class: BinaryConverter
 *
 * Description:
 *
 *
 ****************************************
 */

package lab04;


import java.util.Scanner;

public class BinaryConverter {
    private static String binaryInput; //stores user input for binary numbers
    private static Scanner sc = new Scanner(System.in); //scanner class

    /**
     * our main program... asks for a binary input, and converts it to base 10
     * @param args command line arguments supplied to the program
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the binary converter.");
        boolean cont = true;
        while (cont == true) {
            getUserInput();
            int converted = convertBinaryToInt(binaryInput);
            System.out.println(converted);
            if (promptContinue()==false){
                cont = false;
            }
        }

    }

    /**
     * gets user input for a valid binary number
     */
    public static void getUserInput(){
        boolean isDone = false;
        while(!isDone){
            System.out.print("Enter a binary number: ");
            binaryInput = sc.nextLine().strip();
            if (binaryInput.matches("^[01]+$")){
                isDone=true;
            }
            else{
                System.out.print("ERROR! Try again. ");
            }
        }

    }

    /**
     * converts the given base 2 input to base 10
     * @param s valid String input in base 2
     * @return converted integer in base 10
     */
    public static int convertBinaryToInt(String s){
        int sum = 0; //holds the sum of each base 2 '1' and their base 10 values
        char[] chArray = s.toCharArray(); //converts string to charArray
        int i = 0; //incremental value for calculating each base 2 unit to base 10

        for (char ch : chArray){
            if (ch == '1') {
                sum= (int) (sum+(Math.pow(2,chArray.length-i-1)));
            }
            i++;
        }
        return sum;
    }

    /**
     * prompts the user on whether they would like to continue?
     * @return true when the user types a y or false for anything else
     */
    public static boolean promptContinue() {
        System.out.print("Try again? [Y/N] ");
        String yesOrNo = sc.nextLine().strip();
        if (yesOrNo.toLowerCase().charAt(0) == 'y') {
            return true;
        }
        else {
            return false;
        }
    }
}
