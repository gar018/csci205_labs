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
 * Class: TempConverterView
 *
 * Description:
 * This represents the basic GUI part of our temperature converter.
 * This includes the code to create the scene graph for the app, and
 * the styling of the display.
 * ****************************************
 */

package lab10.tempconvertermvc;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * This is the "view" in the MVC design for the temperature converter. A view class
 * does nothing more than initializes all nodes for the scene graph for this view.
 */
public class TempConverterView {

    /** The model that contains the data and logic behind this view */
    private TempConverterModel theModel;

    /** Root node for the scene graph */
    private VBox root;

    /** topPane is the {@link FlowPane} layout container for the top of the view */
    private FlowPane topPane;

    /** The {@link TextField} control where the user enters text */
    private TextField textFieldTempInput;

    /** The {@link Label} that shows the result of the temperature conversion */
    private Label lblResult;

    /** The {@link Button} that initiates a temperature conversion */
    private Button btnConvert;

    /**
     * Construct a new instance of the entire scene graph for
     * this view
     */
    public TempConverterView(TempConverterModel theModel) {
        this.theModel = theModel;
        initSceneGraph();
        initStyling();
    }

    /**
     * Return the root node of the scene graph for this view
     * @return
     */
    public Parent getRoot() {
        return root;
    }

    /**
     * Get the text field that contains the TextField control where
     * the user enters the temperature
     *
     * @return the {@link TextField} instance where the user enters the temperature
     */
    public TextField getTextFieldTempInput() {
        return textFieldTempInput;
    }

    /**
     * @return the {@link Label} where the result of the conversion should be
     * shown
     */
    public Label getLblResult() {
        return lblResult;
    }

    /**
     * @return the {@link Button} that initiates the temperature conversion
     * calculation
     */
    public Button getBtnConvert() {
        return btnConvert;
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        root = new VBox();

        // Set up top pane container to hold the text field to
        // enter a temperature
        topPane = new FlowPane();

        // Text Field to enter the temperature
        textFieldTempInput = new TextField();

        // Add leaf nodes for top pane
        topPane.getChildren().add(new Label("Temperature (F):"));
        topPane.getChildren().add(textFieldTempInput);

        // Middle section will show the result
        lblResult = new Label("");

        // Set up the button to initiate the conversion
        btnConvert = new Button("Convert!");

        // Add the three main sections for the VBox root container
        root.getChildren().add(topPane);
        root.getChildren().add(lblResult);
        root.getChildren().add(btnConvert);
    }

    /**
     * Apply appropriate styles to all of the content in the scene graph
     * for this view
     */
    public void initStyling() {
        root.setSpacing(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);

        topPane.setOrientation(Orientation.HORIZONTAL);
        topPane.setAlignment(Pos.CENTER);
        topPane.setHgap(10);

        textFieldTempInput.setAlignment(Pos.CENTER);
        textFieldTempInput.setPrefColumnCount(5);

        lblResult.setPrefWidth(75);
        lblResult.setPrefHeight(25);

        // Set up a border to appear around the converted temp
//        lblResult.setBorder(new Border(new BorderStroke(null,
//                                                        BorderStrokeStyle.SOLID,
//                                                        new CornerRadii(4),
//                                                        BorderWidths.DEFAULT)));
        // Let's use CSS instead!
        lblResult.setStyle("-fx-border-style: solid; " +
                           "-fx-border-radius: 4");

        lblResult.setAlignment(Pos.CENTER);
    }
}
