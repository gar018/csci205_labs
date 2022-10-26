/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/24/22* Time: 9:39 AM
 *
 * Project: csci205_labs
 * Package: lab10.trafficlightmvc.model
 * Class: TrafficLightModel
 *
 * Description:
 *
 *
 ****************************************
 */

package lab10.trafficlightmvc.model;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

public class TrafficLightModel {

    /**
     * Our array list of {@link Light} objects for our traffic light
     */
    private ArrayList<Light> lights;

    /**
     * are our lights going to turn off automatically?
     */
    private SimpleBooleanProperty isAutoOff;

    /**
     * TrafficLightModel constructor
     * initializes the color enums as lights and appends to an array
     * isAutoOff defaults to the off state
     */
    public TrafficLightModel() {
        // a traffic light will utilize an arraylist to hold lights
        this.lights = new ArrayList<>();

        //init colors and add them to the array
        for (LightColorEnum light : LightColorEnum.values()) {
            this.lights.add(new Light(light.getColor()));
        }

        //init the autooff property
        this.isAutoOff = new SimpleBooleanProperty(false);
    }

    public ArrayList<Light> getLights() {
        return lights;
    }

    /**
     * gathers the light at the specific value in the arraylist
     * @param i the point in the arraylist being referenced
     * @return that specific light object
     */
    public Light getLight(int i) {
        return this.lights.get(i);
    }

    public boolean isIsAutoOff() {
        return isAutoOff.get();
    }

    public SimpleBooleanProperty isAutoOffProperty() {
        return isAutoOff;
    }
}
