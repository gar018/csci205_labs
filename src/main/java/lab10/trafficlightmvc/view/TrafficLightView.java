/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/24/22* Time: 1:18 PM
 *
 * Project: csci205_labs
 * Package: lab10.trafficlightmvc.view
 * Class: TrafficLightView
 *
 * Description:
 *
 *
 ****************************************
 */

package lab10.trafficlightmvc.view;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import lab10.trafficlightmvc.model.Light;
import lab10.trafficlightmvc.model.TrafficLightModel;

import java.util.ArrayList;

public class TrafficLightView {

    /** reference to the model for the TrafficLight MVC */
    private TrafficLightModel theModel;

    /** the root of the scene graph-- is a VBox Object containing each light */
    private VBox root;

    /** checkbox determining whether the lights turn off on their own */
    private CheckBox checkBoxAutoOff;

    /** an ArrayList storing the Circle objects */
    private ArrayList<Circle> lights;

    public VBox getRoot() {
        return root;
    }

    public CheckBox getCheckBoxAutoOff() {
        return checkBoxAutoOff;
    }

    public ArrayList<Circle> getLights() {
        return lights;
    }

    /**
     * returns a specific light from the array
     * @param i the index of the light
     * @return the light at that index i
     */
    public Circle getLight(int i ) {
        return lights.get(i);
    }
    public TrafficLightView(TrafficLightModel theModel) {
        this.theModel = theModel;

        initSceneGraph();
        initStyling();
    }

    private void initSceneGraph() {
        //init the root
        this.root = new VBox();

        //init checkbox
        this.checkBoxAutoOff = new CheckBox("Auto off");
        this.checkBoxAutoOff.setSelected(theModel.isIsAutoOff());

        //init lights
        this.lights = new ArrayList<>();
        for (Light modelLight : theModel.getLights()) {
            //set initial size to be 50
            Circle light = new Circle(50);

            //set a style class to be used in CSS later
            light.getStyleClass().add("light");

            //set the fill color based on the model
            light.setFill(modelLight.getCurrentColor());

            //add the light to the array
            lights.add(light);
        }

        //add the checkbox + lights to the root
        this.root.getChildren().add(this.checkBoxAutoOff);
        this.root.getChildren().addAll(this.lights);

    }

    private void initStyling() {

    }
}
