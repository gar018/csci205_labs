/* *****************************************
*CSCI205 -Software Engineering and Design* Fall 2022
* Instructor: Prof. King
* Section: 01 - 9:00-9:50AM
*
* Name: Gordon Rose
* Date: 08/31/2002
* Lab / Assignment: lab02
*
* Description: Die class file
*
* *****************************************/
package lab02;
import java.util.Random;
import java.util.Scanner;
public class Die {
    //what is the lowest number the die can "roll" on?
    public static final int MIN_FACE_VALUE = 1;
    //what is the highest number the die can "roll" on?
    public static final int MAX_FACE_VALUE = 6;
    //how many rolls the program will perform
    public static final int NUMBER_OF_ROLLS = 1000000;
    //Random Number Generator
    private static Random rng = new Random(1234);
    //Store the face value of the last roll:
    private int lastRollValue;
    public Die() { //Constructor class for Die
        this.lastRollValue=0;
    }
    //lastRollValue getter method
    public int getlastRollValue() { return this.lastRollValue;}

    //provides a random integer from MIN_FACE_VALUE to MAX_FACE_VALUE for the die
    public int roll() {
        int spread = MAX_FACE_VALUE - MIN_FACE_VALUE + 1;
        this.lastRollValue=Die.rng.nextInt(spread) + MIN_FACE_VALUE;
        return this.lastRollValue;
    }
    //Returns the last roll as a string
    public String toString(){
        return "" + this.lastRollValue;
    }

    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        boolean validAnswer=false;
        int input = 0;
        while (!validAnswer) { 
            System.out.println("What dice sum do you want to check for?");
            boolean isInteger = sc.hasNextInt();
            if (!isInteger) {
                System.out.println("ERROR! Invalid value entered! 2-12 only. Try again.");
                sc.nextLine();
            }
            else if (isInteger){
                input = sc.nextInt();
                if (input > 12 || input < 2) {
                    System.out.println("ERROR! Invalid value entered! 2-12 only. Try again.");
                    sc.nextLine();
                }
                else {
                    validAnswer = true;
                }
            }
        }
        sc.close();
        return input;
    }

    public static int rollSequence(int givenSum) {
        Die die1 = new Die();//Make Die Object
        Die die2 = new Die();//Make second Die Object
        int frequency = 0;//the number of times the input number shows up in x amount of rolls
        for (int i = 0; i < NUMBER_OF_ROLLS; i++) {
            int dieSum = die1.roll()+die2.roll();
            if (dieSum == givenSum) {
                frequency++;
            }
        }
        return frequency;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the dice simulator!");
        System.out.println("I'm going to roll 2 dice 1000000 times");
        //Get user input (ignore invalid inputs)
        int input = getUserInput();
        //roll the die 1 mil times!
        long startTime = System.nanoTime();
        int frequency = rollSequence(input);
        long elapsedTime = System.nanoTime()-startTime;
        double elapsedTimeInMilliseconds = (double)elapsedTime*1E-6;
        double percentFreq = ((double)frequency/NUMBER_OF_ROLLS)*100.0;
        //Print summary out
        System.out.printf("The roll value %d appeared %d times, or %.3f%% of all rolls.%n",input,frequency,percentFreq);
        System.out.printf("%d rolls took %.3f ms.%n",NUMBER_OF_ROLLS,elapsedTimeInMilliseconds);
        System.out.println("Goodbye.");
    }
}
