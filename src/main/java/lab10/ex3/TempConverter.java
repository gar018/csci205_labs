/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/19/22* Time: 9:05 PM
 *
 * Project: csci205_labs
 * Package: lab10.ex3
 * Class: TempConverter
 *
 * Description: a simple program that converts fahrenheit to celsius
 *
 *
 ****************************************
 */

package lab10.ex3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TempConverter extends Application {

    /**
     * the root of the scene graph
     */
    private VBox root;

    /**
     * the top pane holding the 'Temperature' label and a text input field
     */
    private FlowPane topPane;

    /**
     * temperature input text field
     * @param args
     */
    private TextField textFieldTempInput;

    /**
     * Label used to show result
     */
    private Label lblResult;

    /**
     * Button to convert the given temperature
     * @param args
     */
    private Button btnConvert;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        initSceneGraph();
        initStyling();
        initEventHandlers();

        primaryStage.setScene(new Scene(this.root));

        primaryStage.sizeToScene();

        primaryStage.setTitle("F to C Converter");

        primaryStage.show();

    }

    /**
     * initialize the components of the scene graph
     */
    private void initSceneGraph() {
        root = new VBox();

        // create topPane content
        topPane = new FlowPane();

        topPane.getChildren().add(new Label("Temperature (F)"));

        textFieldTempInput = new TextField();
        topPane.getChildren().add(textFieldTempInput);

        root.getChildren().add(topPane);

        // create result Label content
        lblResult = new Label();
        root.getChildren().add(lblResult);

        // create convert button
        btnConvert = new Button();
        root.getChildren().add(btnConvert);
    }

    /**
     * initialize the styling of the components of the scene graph
     */
    private void initStyling() {
        //style root
        root.setSpacing(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10,5,10,5));
        root.setAlignment(Pos.CENTER);

        //style topPane
        topPane.setOrientation(Orientation.HORIZONTAL);
        topPane.setAlignment(Pos.CENTER);
        topPane.setHgap(10);

        //style Temperature Input Text Field
        textFieldTempInput.setAlignment(Pos.CENTER);
        textFieldTempInput.setPrefColumnCount(5);

        //style Result Label
        lblResult.setAlignment(Pos.CENTER);
        lblResult.setPrefWidth(75);
        lblResult.setPrefHeight(25);
        lblResult.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(4),BorderWidths.DEFAULT)));

        //style Convert Button
        btnConvert.setText("Convert!");
    }

    /**
     * initialize the event handlers within the scene graph
     */
    private void initEventHandlers() {
        //btnConvert event handler
        btnConvert.setOnAction(event -> {
            lblResult.setText(convertFtoC(textFieldTempInput.getText()));
        });

        //textFieldTempInput event handler
        textFieldTempInput.setOnAction(btnConvert.getOnAction());
    }

    /**
     * converts a given string to celsius returned as a string
     * @param inputFTemp
     * @return
     */
    private String convertFtoC(String inputFTemp) {
        try {
            return String.format("%.1f",((Double.parseDouble(inputFTemp)-32.0)*(5.0/9.0)));
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid input!");
            alert.setHeaderText("Invalid input specified!");
            alert.setContentText(String.format("Cannot convert \"%s\"!",inputFTemp));
            alert.show();
        }
        return "N/A";
    }
}
