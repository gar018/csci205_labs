/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Author: Prof. King
 *
 * Name: YOUR NAME
 * Date: 10/16/2022
 * Time: 9:30 PM

 * Project: csci205_labs
 * Class: TempConverterController
 *
 * Description:
 *
 * ****************************************
 */

package lab10.tempconvertermvc;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
 * This is the MVC controller class for our temperature converter app
 */
public class TempConverterController {
    private TempConverterModel theModel;
    private TempConverterView theView;

    /**
     * Construct a controller that connects the model and the view for our
     * temperature conversion program
     *
     * @param theModel
     * @param theView
     */
    public TempConverterController(TempConverterModel theModel, TempConverterView theView) {
        this.theModel = theModel;
        this.theView = theView;

        initEventHandlers();
    }

    /**
     * This is an internal helper method to initialize the event handlers
     */
    private void initEventHandlers() {
        this.theView.getBtnConvert().setOnAction(this::handleActionEvent);
        this.theView.getTextFieldTempInput().setOnAction(this::handleActionEvent);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handleActionEvent(ActionEvent event) {
        try {
            String s = this.theView.getTextFieldTempInput().getText();
            String result = this.theModel.convertFtoC(s);
            this.theView.getLblResult().setText(result);
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.setContentText(String.format("Can not convert \"%s\"",
                                               this.theView.getTextFieldTempInput().getText()));
            alert.show();
        }
    }
}
