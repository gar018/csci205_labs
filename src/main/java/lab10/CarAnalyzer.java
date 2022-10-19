/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: YOUR NAME
 * Date: 10/13/2022
 * Time: 11:26 AM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: CarAnalyzer
 * Description:
 *
 * ****************************************
 */

package lab10;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A simple checked exception to check for wrong answers from each test below
 */
class CarAnalyzerException extends Exception {
    public CarAnalyzerException(String message) {
        super(message);
    }
}

/**
 * A class that encapsulates a collection of Car instances, a constructor that
 * will handle reading in a dataset of cars (called "auto-mpg.csv"), and
 * a series of tests that the student must complete using the Streams API
 *
 * NOTE - this closely mirrors many of the examples presented in the lecture on
 * the Streams API - WATCH IT FIRST!
 */
public class CarAnalyzer {

    /** The collection of Car instances */
    private final ArrayList<Car> cars;

    /**
     * Construct an instance of CarAnalyzer that takes a filename representing
     * the name of the auto-mpg.csv dataset, and reads in the entire dataset,
     * storing it in our ArrayList<Car> object.
     *
     * @param sFileName is the name of the file, which should be stored
     *                  in the resources folder
     */
    public CarAnalyzer(String sFileName) {
        ArrayList<Car> cars = new ArrayList<>();

        InputStream inStream = Car.class.getClassLoader().getResourceAsStream(sFileName);
        Scanner sc = new Scanner(inStream);
        sc.nextLine();
        while(sc.hasNextLine()){
            cars.add(new Car(sc.nextLine()));
        }
        this.cars = cars;
        System.out.printf("Stored %d cars.\n", this.cars.size());
    }

    /**
     * test1
     *
     * Print the total number of cars that have four cylinders
     */
    public void test1() throws CarAnalyzerException {
        System.out.println("**** test1() ****");
        System.out.println("==> Number of cars with 4 cylinders");

        long totalWith4cyl = 0;

        // TODO - Finish test1() - store result in totalWith4cyl




        System.out.println(totalWith4cyl);
        if (totalWith4cyl != 204) throw new CarAnalyzerException("test1() fail");
    }

    /**
     * test2
     *
     * Count the number of cars that have 4 cylinders and at least 35 mpg
     */
    public void test2() throws CarAnalyzerException {
        System.out.println("**** test2() ****");
        System.out.println("==> Count of cars with 4 cylinders and at least 35 mpg");

        long total = 0;

        // TODO - Finish test2() - store result in total





        System.out.println(total);
        if (total != 34) throw new CarAnalyzerException("test2() fail");
    }

    /**
     * test3
     *
     * Print a list of the names of the cars with 4 cylinders and at
     * least 35 mpg. Each car is printed on its own line in the format:
     *
     * name : year=??, mpg=??.?.
     *
     * For example, one line should be:
     * datsun 1200 : Year=71, mpg=35.0
     */
    public void test3() {
        System.out.println("**** test3() ****");
        System.out.println("==> List of cars with 4 cylinders and at least 35 mpg");

        // TODO - Finish test3() - print results to System.out



    }

    /**
     * test4
     *
     * What is the lowest and highest mpg observed in this dataset?
     *
     * HINT - you could do this with two different streams, but it can
     * be done with just one stream and a DoubleSummaryStatistics object.
     */
    public void test4() throws CarAnalyzerException {
        System.out.println("**** test4() ****");
        System.out.println("==> The lowest and highest mpg in this dataset");

        double minMpg = 0;
        double maxMpg = 0;

        // TODO - Finish test4() - be sure to start results in minMpg and maxMpg





        System.out.printf("Min MPG = %.1f, Max MPG = %.1f\n",minMpg,maxMpg);
        if (minMpg != 9 || maxMpg != 46.6) throw new CarAnalyzerException("test4() fail");
    }

    /**
     * test5
     *
     * What is the manufacturer of the car with the highest mpg?
     *
     * NOTE - the manufacturer is the first word in the name field. For example,
     * "plymouth horizon miser" would have a manufacturer of "plymouth"
     */
    public void test5() throws CarAnalyzerException {
        System.out.println("**** test5() ****");
        System.out.println("==> The make of the car with the highest mpg");

        String carBrand = "";

        // TODO - Finish test5() - store result in carBrand



        System.out.println(carBrand);
        if (!carBrand.equals("mazda")) throw new CarAnalyzerException("test5() fail");
    }

    /**
     * test6
     *
     * Obtain a list of distinct manufacturer names in the dataset
     * as a List<String> object
     */
    public void test6() throws CarAnalyzerException {
        System.out.println("**** test6() ****");
        System.out.println("==> The list of distinct brand names in the dataset");

        List<String> brands = null;

        // TODO - Finish test6() - store result in brands





        System.out.println(brands);
        System.out.println("Total number of brands: " + brands.size());
        if (brands.size() != 37) throw new CarAnalyzerException("test6() - fail");
    }

    /**
     * test7
     *
     * What is the distribution of cars by cylinder? For this one, you should end up
     * with a Map<<Integer, Long> data collection that has the cylinder value
     * integer as the key, and the number of cars as the value
     */
    public void test7() throws CarAnalyzerException {
        System.out.println("**** test7() ****");
        System.out.println("==> Distribution of number of cars by cylinder");

        Map<Integer,Long> mapOfCars = null;

        // TODO - Finish test7() - store result in mapOfCars




        System.out.println(mapOfCars);
        if (mapOfCars.keySet().size() != 5 || mapOfCars.get(3) != 4 || mapOfCars.get(4) != 204)
            throw new CarAnalyzerException("test7() - fail");
    }

    /**
     * test8
     *
     * Print out the name, year, cylinder and mpg of all Volvo's in the dataset. Each
     * car should be printed on its own line
     *
     * For example, one line should be:
     * "volvo 145e (sw) year=72 cyl=4 mpg=18.0"
     */
    public void test8() {
        System.out.println("**** test8() ****");
        System.out.println("==> Model year cylinder and mpg of all Volvo's");

        // TODO - Finish test8() - Print results to System.out



    }

    /**
     * test9
     *
     * Print the number of cars by manufacturer to the output. This should result
     * in a list printed with the manufacturer, and the count.
     *
     * You should print in the following format:
     * manufacturer --> count
     *
     * For example:
     * vw --> 6
     * buick --> 17
     * mercury --> 11
     * ...
     *
     */
    public void test9() {
        System.out.println("**** test9() ****");
        System.out.println("==> Print the number of cars by manufacturer:");

        // TODO - Finish test9() - Print results to System.out




    }

    /**
     * test10
     *
     * Which car manufacturer has the largest number of cars in the dataset?
     */
    public void test10() throws CarAnalyzerException {
        System.out.println("**** test10() ****");
        System.out.println("==> Car manufacturer with the largest number of cars in the dataset");

        String carName = "";

        // TODO - Finish test10()



        System.out.println(carName);
        if (!carName.equals("ford"))
            throw new CarAnalyzerException("test10() - fail");
    }

    /**
     * A main program to run all of the tests. It checks ofr the occurrence of
     * a CarAnalyzerException and will stop tests if one occurrs
     *
     * @param args
     */
    public static void main(String[] args) {

        CarAnalyzer analyzer = new CarAnalyzer("auto-mpg.csv");
        System.exit(0);
        try {
            analyzer.test1();
            analyzer.test2();
            analyzer.test3();
            analyzer.test4();
            analyzer.test5();
            analyzer.test6();
            analyzer.test7();
            analyzer.test8();
            analyzer.test9();
            analyzer.test10();
        }
        catch (CarAnalyzerException e) {
            System.err.println(e.getMessage());
        }
    }

}
