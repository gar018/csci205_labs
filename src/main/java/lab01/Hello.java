/* *****************************************
*CSCI205 -Software Engineering and Design* Fall 2022
* Instructor: Prof. King
* Section: 01 - 9:00-9:50AM
*
* Name: Gordon Rose
* Date: 08/28/2002
* Lab / Assignment: lab01
*
* Description: a basic "hello world" java program
*
* *****************************************/

package lab01;
import java.util.Scanner;
public class Hello
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = sc.nextLine();
        System.out.println(userName + ", programming is not a spectator sport!");
        System.out.println(userName + ", your name is " + userName.length() + " characters long.");
        System.out.println("What is your age?");
        int userAge = sc.nextInt();
        if (userAge < 20) {
            System.out.println("You're a teenager.");
        }
        else if (userAge >= 30) {
            System.out.println("You're at least 30.");
        }
        else{
            System.out.println("You're in your 20s.");
        }
        sc.close();
        System.exit(0);
    }
}