/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 * Instructor: Prof. Brian King
 * Section: 9:00-9:50AM
 *
 * Name: Gordon
 * Date: 08/31/2022
 *
 * Lab / Assignment: lab02
 *
 * Description:
 * This is a simple program to help you understand wrapper classes and autoboxing,
 * and understand that object convenience may come at a computational cost.
 * *****************************************/

package lab02;

public class PrimitivePerf {

    /** The quantity of numbers to compute a sum for */
    private static final int MAX_NUMBERS = 10000000;

    /** MAIN PROGRAM */
    public static void main(String[] args) {
        // Our time durations we will use to store our results
        long primitiveDuration = 0L;
        long wrappedDuration = 0L;

        // Evaluate the test with primitive types
        System.out.println("Primitive:");
        long startTime = System.nanoTime();
        long primitiveResult = testPrimitive();
        primitiveDuration = System.nanoTime() - startTime;
        System.out.println("Answer = " + primitiveResult + ". Time = " + primitiveDuration + " ns");

        // Now, evaluate the test with the wrapper class type
        System.out.println("Wrapped:");
        startTime = System.nanoTime();
        Long wrappedResult = testWrapped();
        wrappedDuration = System.nanoTime() - startTime;
        System.out.println("Answer = " + wrappedResult + ". Time = " + wrappedDuration + " ns");
        // TODO - Print results, timing, and pct difference between times
        // *** PLEASE NOTE: ***
        // I have placed the print results and timing around each test evaluation (lines 31 and 35 for primitive, 38 and 42 for wrapped)
        // the following lines of code are ONLY for pct differences between the two times:
        double durationRatio = (double)(primitiveDuration)/(wrappedDuration);
        System.out.printf("Primitive types used %.1f%% of the time of wrapper objects.%n",durationRatio);
    }

    /**
     * Simple function to evaluate the speed of adding numbers that are
     * primitive types
     */
    public static long testPrimitive() {
        // Store the result as a primitive type
        long sum = 0L;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            sum = sum + i;
        }

        return sum;
    }

    /**
     * Simple function to evaluate the speed of adding numbers that are stored
     * as an object.
     */
    public static Long testWrapped() {
        // Store the result as an object Long, not the primitive type!
        Long objSum = 0L;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            objSum = objSum + i;
        }

        return objSum;
    }
}
