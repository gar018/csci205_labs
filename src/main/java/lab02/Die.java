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
public class Die {
    //what is the lowest number the die can "roll" on?
    public static final int MIN_FACE_VALUE = 1;
    //what is the highest number the die can "roll" on?
    public static final int MAX_FACE_VALUE = 6;
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
    public static void main(String[] args) {
        Die die = new Die();

        //roll the die
        die.roll();
        System.out.println("I rolled: " + die);
        System.out.println("Goodbye!");
    }
}
