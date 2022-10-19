/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/18/22* Time: 10:34 AM
 *
 * Project: csci205_labs
 * Package: lab10
 * Class: Car
 *
 * Description:
 *
 *
 ****************************************
 */

package lab10;

/**
 * The Car Class
 * contains information about a car's specs and model
 */
public class Car {

    /**
     * miles per gallon
     */
    private double mpg;

    /**
     * engine's cylinder count
     */
    private int cylinders;

    /**
     * car's engine displacement
     */
    private double displacement;

    /**
     * car's horsepower
     */
    private double horsepower;

    /**
     * car's weight
     */
    private double weight;

    /**
     * car's acceleration
     */
    private double accel;

    /**
     * car's model year
     */
    private int modelYear;

    /**
     * car's origin
     */
    private int origin;

    /**
     * name of car
     */
    private String carName;

    public Car(String csvRecord) {
        String[] dataArray = csvRecord.split(",");

        this.mpg = initializeDouble(dataArray[0]);
        this.cylinders = initializeInt(dataArray[1]);
        this.displacement = initializeDouble(dataArray[2]);
        this.horsepower = initializeDouble(dataArray[3]);
        this.weight = initializeDouble(dataArray[4]);
        this.accel = initializeDouble(dataArray[5]);
        this.modelYear = initializeInt(dataArray[6]);
        this.origin = initializeInt(dataArray[7]);
        this.carName =initializeString(dataArray[8]);
    }

    public double initializeDouble(String data) {
        double var = 0.0;
        try {
            var = Double.parseDouble(data);
        }
        catch(NumberFormatException e) {
            return var;
        }
        return var;
    }

    public int initializeInt(String data) {
        int var = 0;
        try {
            var = Integer.parseInt(data);
        }
        catch(NumberFormatException e) {
            return var;
        }
        return var;
    }

    public String initializeString(String data) {
        String var = "";
        var = data;
        return var;
    }
    // SETTER AND GETTER METHODS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public double getMpg() {
        return mpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public double getWeight() {
        return weight;
    }

    public double getAccel() {
        return accel;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getOrigin() {
        return origin;
    }

    public String getCarName() {
        return carName;
    }
}
