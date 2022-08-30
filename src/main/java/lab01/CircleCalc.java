package lab01;
import java.util.Scanner;

public class CircleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double circleDegrees = -1; //Automatically given a sentinel value to show a valid inumber has not been input.
        double circleRadius = -1; //Automatically given a sentinel value to show a valid inumber has not been input.
        //SYSTEM INPUT-------------------------------------------------------------
        System.out.print("Please enter the angle in degrees [0-360): ");
        while (true) { //Until a valid input is given, then break;
            if (sc.hasNextDouble()) {
                circleDegrees = sc.nextDouble();
                if (circleDegrees >= 0 && circleDegrees < 360) {
                    break;
                }
            }
            System.out.print("Please enter a valid number [0-360): ");
            sc.nextLine();
        }
        sc.nextLine();
        System.out.print("Please enter the radius (>0): ");
        while (true) { //Until a valid input is given, then break;
            if (sc.hasNextDouble()) {
                circleRadius = sc.nextDouble();
                if (circleRadius > 0) {
                    break;
                }
            }
            System.out.print("Please enter a valid number (>0): ");
            sc.nextLine();
        }
        sc.nextLine();
        //CALCULATION--------------------------------------------------------------
        double circleRadians= DegreesToRadians(circleDegrees);
        double xCoord = RoundValue(Math.cos(circleRadians) * circleRadius); //x=rcos(theta)
        double yCoord = RoundValue(Math.sin(circleRadians) * circleRadius); //y=rsin(theta)
        String quadrant = DetermineQuadrant(xCoord,yCoord);
        //PRINT RESULTS------------------------------------------------------------
        System.out.println("Quadrant: " + quadrant);
        System.out.printf("Your coordinates are: (%.2f , %.2f)",xCoord,yCoord);
        System.out.println("\nGoodbye!");
    }

    static double DegreesToRadians(double radians) { 
        //Convert from Degrees to Radians
        radians = (radians / 180) * Math.PI;
        return radians;
    }

    static String DetermineQuadrant(double x, double y) {
        //Determine Quadrant by comparing positive or negative values
        if (y > 0) {
            if (x > 0) {
                return "1";
            }
            else if (x < 0) {
                return "2";
            }
        }
        else if (y < 0) {
            if (x > 0) {
                return "4";
            }
            else if (x < 0) {
                return "3";
            }
        }
        return "IN BETWEEN QUADRANTS";
    }

    static double RoundValue(double value) {
        //Rounds value to two nearest digits- needed to round off small calc errors to correctly designate quadrants
        value = Math.round(value * 100);
        value = value/100;
        return value;
    }
}
