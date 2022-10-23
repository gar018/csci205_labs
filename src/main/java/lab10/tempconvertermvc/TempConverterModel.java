/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2022
 *
 * Author: Prof. King
 *
 * Name: YOUR NAME
 * Date: 03/20/2022
 * Time: 9:30 PM

 * Project: csci205_labs
 * Class: TempConverterModel
 * Description:
 *
 * ****************************************
 */

package lab10.tempconvertermvc;

/**
 * This is the "model" for our temp converter program. There really is not
 * much to a model in this particular program. The only logic that can be separated
 * out are those functions that do conversions
 */
public class TempConverterModel {
    private static final String DEFAULT_FORMATTER = "%.1f";
    private String sFormatter;

    /**
     * Initialize a new model
     */
    public TempConverterModel() {
        this.sFormatter = DEFAULT_FORMATTER;
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
        return String.format(this.sFormatter, tempC);
    }
}
