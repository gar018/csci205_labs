/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/24/22* Time: 8:57 AM
 *
 * Project: csci205_labs
 * Package: lab10.trafficlightmvc.model
 * Class: Light
 *
 * Description: The Light Class for the Traffic Light MVC Program
 *
 *
 ****************************************
 */

package lab10.trafficlightmvc.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * A simple abstraction for a basic light that can turn on and off.
 * Our light will also have a color which the class will manage
 * to simulate darkening
 */
public class Light {

    /** Is the light on? */
    private SimpleBooleanProperty isOn;

    /** The current color of the light */
    private SimpleObjectProperty<Color> currentColor;

    /** The light's on color */
    private Color onColor;

    /** The light's off color */
    private Color offColor;


    /**
     * constructor of the Light class
     * will configure the light automatically to its off color
     *
     * @param color represents the 'on' color of the light
     */
    public Light(Color color) {
        isOn = new SimpleBooleanProperty(false);

        offColor = color.darker();
        onColor = color;
        this.currentColor = new SimpleObjectProperty<>();
        this.currentColor.set(this.offColor);
    }

    /**
     * changes the state of the light to on or off
     */
    public void toggle() {
        this.isOn.set(!this.isOn.get());

        if (this.isIsOn()) this.currentColor.set(this.onColor);
        else this.currentColor.set(this.offColor);
    }

    public void turnOnForMs(long ms) {
        Runnable r = () -> {
            try {
                //if we're not on, turn on
                if (!this.isIsOn())
                    toggle();
                Thread.sleep(ms);
            }
            catch(InterruptedException e) {
                //nothing to do once caught
            }
            finally {
                //if we're on, turn off
                if (this.isIsOn()) {
                    toggle();
                }
            }
        };

        //encapsulate our runnable in a thread and start it!
        Thread t = new Thread(r);
        t.start();

    }
    public boolean isIsOn() {
        return isOn.get();
    }

    public SimpleBooleanProperty isOnProperty() {
        return isOn;
    }

    public Color getCurrentColor() {
        return currentColor.get();
    }

    public SimpleObjectProperty<Color> currentColorProperty() {
        return currentColor;
    }
}
