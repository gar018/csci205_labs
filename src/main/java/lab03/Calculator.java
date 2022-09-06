/* *****************************************
*CSCI205 -Software Engineering and Design* Fall 2022
* Instructor: Prof. King
* Section: 01 - 9:00-9:50AM
*
* Name: Gordon Rose
* Date: 9/5/2002
* Lab / Assignment: lab03
*
* Description: Creating a calculator using a switch statement 
*
* *****************************************/
package lab03;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to The Calculator");
        System.out.println("Enter expressions with two numeric operands");
        System.out.println("and a single operator from +, -, *, /, %, or ^");
        boolean quit=false;
        //input and calculation cycles until the user inputs an n
        do {
            Double result = calculate(getUserInput(sc));
            System.out.printf("The answer is %.4f%n",result);
            System.out.print("Continue? [y/n]: ");
            if (sc.next().equals("n")) {
                quit=true;
            }
            sc.nextLine();
        } while(!quit);
    }
    public static String[] getUserInput(Scanner sc) { 
        //repeatedly asks for valid user input until given, then returns it
        String operand1 = "";
        String operand2 = "";
        String operator = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a simple arithmetic expression with spacing: ");
            if(sc.hasNextDouble()){
                operand1=sc.next();
                operator = sc.next();
                if(validOperator(operator)){
                    if(sc.hasNextDouble()){
                        operand2=sc.next();
                        valid=true;
                    }
                    else {
                        System.out.println("Error: could not parse operand 2");
                    }
                }
                else {
                    System.out.println("Error: "+operator+" is not a valid operator");
                }
            }
            else {
                System.out.println("Error: could not parse operand 1");
            }
            sc.nextLine();
        }

        //puts the 3 inputs into an array and returns it
        String[] outputArray = {operand1,operand2,operator};
        return outputArray;
    }

    public static boolean validOperator(String input) { //checks for a valid operator ch
        return (input.length() == 1 && (input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/") || input.contains("%") || input.contains("^")));
    }

    public static Double calculate(String[] ops) { //calculates using a switch statement
        Double num1= Double.parseDouble(ops[0]);
        Double num2= Double.parseDouble(ops[1]);
        char operator = ops[2].charAt(0);
        Double result=0.0;
        switch (operator) {
            case '+': result=num1+num2; break;
            case '-': result=num1-num2; break;
            case '*': result=num1*num2; break;
            case '/': result=num1/num2; break;
            case '%': result=num1%num2; break;
            case '^': result=Math.pow(num1,num2); break;
        }
        return result;
    }
}


