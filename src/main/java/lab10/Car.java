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

        initialize(this.mpg,dataArray[0]);
        initialize(this.cylinders,dataArray[1]);
        initialize(this.displacement,dataArray[2]);
        initialize(this.horsepower,dataArray[3]);
        initialize(this.weight,dataArray[4]);
        initialize(this.accel,dataArray[5]);
        initialize(this.modelYear,dataArray[6]);
        initialize(this.origin,dataArray[7]);
    }

    public void initialize(double var, String data) {
        try {
            var = Double.parseDouble(data);
        }
        catch(NumberFormatException e) {
            var = 0.0;
        }
    }

    public void initialize(int var, String data) {
        try {
            var = Integer.parseInt(data);
        }
        catch(NumberFormatException e) {
            var = 0;
        }
    }

    public void initialize(String var, String data) {
        var = data;
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
