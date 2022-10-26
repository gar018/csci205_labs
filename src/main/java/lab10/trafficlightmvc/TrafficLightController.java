/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/25/22* Time: 10:33 AM
 *
 * Project: csci205_labs
 * Package: lab10.trafficlightmvc
 * Class: TrafficLightController
 *
 * Description:
 *
 *
 ****************************************
 */

package lab10.trafficlightmvc;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.scene.shape.Circle;
import lab10.trafficlightmvc.model.Light;
import lab10.trafficlightmvc.model.TrafficLightModel;
import lab10.trafficlightmvc.view.TrafficLightView;

public class TrafficLightController {

    private TrafficLightView theView;
    private TrafficLightModel theModel;

    public TrafficLightController(TrafficLightView theView, TrafficLightModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        initBindings();
        initEventHandlers();
    }

    /**
     * initializes the bindings of properties from the model to parts of the view
     */
    private void initBindings() {
        //bind isAutoOff to the checkbox in the view
        theModel.isAutoOffProperty().bind(theView.getCheckBoxAutoOff().selectedProperty());

        //resize the circles in the GUI depending on the stage size
        NumberBinding radiusBinding =
                Bindings.max(theView.getRoot().heightProperty(),
                             theView.getRoot().widthProperty())
                        .divide(6)
                        .add(-15);

        //import the new size to the Circle radius
        for (Circle c : theView.getLights()) {
            c.radiusProperty().bind(radiusBinding);
        }

        //bind each lights currentColorProperty to the circles color property
        for (int i = 0; i < theModel.getLights().size(); i++) {
            Light lightModel = theModel.getLight(i);
            Circle lightView = theView.getLight(i);

            lightView.fillProperty().bind(lightModel.currentColorProperty());

            //set up a mouse click event to turn on/off a light
            lightView.onMouseClickedProperty().setValue(event -> {
                if(theModel.isIsAutoOff()) lightModel.turnOnForMs(1000);
                lightModel.toggle();

            });
        }
    }

    /**
     * initializes the code to be run when action events occur
     */
    private void initEventHandlers() {

    }
}
