/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2022
 *
 * Author: Prof. King
 *
 * Name: Gordon Rose
 * Date: 03/20/2022
 * Time: 9:30 PM

 * Project: csci205_labs
 * Class: TempConverterModel
 * Description: The Model of the TempConverter JavaFX program
 *
 * ****************************************
 */

package lab10.tempconvertermvc;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * This is the "model" for our temp converter program. There really is not
 * much to a model in this particular program. The only logic that can be separated
 * out are those functions that do conversions
 */
public class TempConverterModel {
    private static final String DEFAULT_FORMATTER = "%.1f";
    private String sFormatter;

    /**
     * a {@link SimpleBooleanProperty} that tracks if the radio button toggle is set to F to C
     */
    private SimpleBooleanProperty isSetForFtoC;

    /**
     * a {@link SimpleBooleanProperty} that tracks if the radio button toggle is set to C to F
     */
    private SimpleBooleanProperty isSetForCtoF;

    /**
     * a {@link SimpleDoubleProperty} that holds the resulting temperature calculated (as Celsius)
     */
    private SimpleDoubleProperty lastTempConvertedInC;

    /**
     * Initialize a new model
     */
    public TempConverterModel() {

        this.sFormatter = DEFAULT_FORMATTER;
        this.isSetForFtoC = new SimpleBooleanProperty(true);
        this.isSetForCtoF = new SimpleBooleanProperty(false);
        this.lastTempConvertedInC = new SimpleDoubleProperty(0);
    }

    /**
     * A simple function that takes a string represents a temperatre
     * in Fahrenheit, and converts it to Celsius
     * @param sFTemp
     * @return a String representing the temp in celsius.
     */
    public String convertFtoC(String sFTemp) {
        Double tempF = Double.parseDouble(sFTemp);
        Double tempC = (tempF - 32.0) * 5.0 / 9.0;
        this.lastTempConvertedInC.set(tempC);
        return String.format(this.sFormatter, tempC);
    }

    /**
     * Simple function that takes a string representing as a
     * temperature in Celsius, and converts to Fahrenheit
     * @param sCTemp
     * @return
     */
    public String convertCtoF(String sCTemp) {
        Double tempC = Double.parseDouble(sCTemp);
        this.lastTempConvertedInC.set(tempC);
        Double tempF = (tempC * (9.0/5.0)) + 32.0;
        return String.format(this.sFormatter, tempF);
    }

    /**
     * uses boolean properties to determine how the temperature
     * string should be handled
     * @param strTemp the {@link String} representing a temperature value
     * @return the converted temperature value as a string
     */
    public String strTempConvert(String strTemp) {
        if(this.isIsSetForFtoC()) {
            return this.convertFtoC(strTemp);
        }
        else if(this.isIsSetForCtoF()) {
            return this.convertCtoF(strTemp);
        }
        else {
            return strTemp; //should never reach here
        }
    }

    public boolean isIsSetForFtoC() {
        return isSetForFtoC.get();
    }

    public SimpleBooleanProperty isSetForFtoCProperty() {
        return isSetForFtoC;
    }

    public boolean isIsSetForCtoF() {
        return isSetForCtoF.get();
    }

    public SimpleBooleanProperty isSetForCtoFProperty() {
        return isSetForCtoF;
    }

    public double getLastTempConvertedInC() {
        return lastTempConvertedInC.get();
    }

    public SimpleDoubleProperty lastTempConvertedInCProperty() {
        return lastTempConvertedInC;
    }
}
