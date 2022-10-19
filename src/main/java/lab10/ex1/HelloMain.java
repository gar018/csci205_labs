/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/19/22* Time: 9:37 AM
 *
 * Project: csci205_labs
 * Package: lab10.ex1
 * Class: HelloMain
 *
 * Description: class file representing introductory programs to JavaFX
 *
 *
 ****************************************
 */

package lab10.ex1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * class file representing introductory programs to JavaFX
 */
public class HelloMain extends Application {

    /**
     * privatized instance of a button
     */
    private Button btn;
    private Label lblTime;

    /**
     * HelloMain main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // StackPane root = new StackPane();
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        initSceneGraph(root);

        //set up scene and place root of the scene graph on top
        Scene scene = new Scene(root, 400, 300);

        //set scene on stage
        primaryStage.setScene(scene);

        //set title for main window
        primaryStage.setTitle("Hello, JavaFX!");

        //display scene
        primaryStage.show();

    }

    /**
     * the root node container for the scnee graph
     * @param root
     */
    private void initSceneGraph(VBox root) {
        //create button and set up event handler
        btn = new Button();
        btn.setText("Report date and time.");

        //create label to display time when button clicked
        lblTime = new Label();

        //add button AND label to root graph
        root.getChildren().add(btn);
        root.getChildren().add(lblTime);

        btn.setOnAction(event -> {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ssa MM/dd/yyyy");
            //System.out.println(ldt.format(formatter));
            lblTime.setText(ldt.format(formatter));
        });


    }
}
