/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/19/22* Time: 10:23 PM
 *
 * Project: csci205_labs
 * Package: lab10.ex4
 * Class: CarPlot
 *
 * Description: Plot of our auto-mpg.csv data
 *
 *
 ****************************************
 */

package lab10.ex4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import lab10.Car;

public class CarPlot extends Application {

    /**
     * name of our data file
     */
    private static String CSV_FILE_NAME = "auto-mpg.csv";

    /**
     * Our array list of Cars
     */
    private ArrayList<Car> cars;


    /**
     * our root of the scene graph
     */
    private BorderPane root;


    /**
     * status bar label
     */
    private Label lblStatusBar;

    /**
     * instance of our scatter plot data
     */
    private CarScatterPlot carScatterPlot;

    /**
     * the main method for CarPlot
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        File file = getFileFromUser(primaryStage);

        readAutoMpgFile(file);


        initSceneGraph();
        //initStyling();
        //initEventHandlers();


        carScatterPlot.plot();

        primaryStage = new Stage();
        primaryStage.setTitle("Car Plotter");
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(
                getClass().getResource("/lab10/CarPlot.css").toExternalForm()
        );
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void initSceneGraph() {
        root = new BorderPane();

        lblStatusBar = new Label();
        lblStatusBar.setId("lblStatusBar");
        root.setBottom(lblStatusBar);
        lblStatusBar.setText(String.format("Read in %d cars.",cars.size()));

        carScatterPlot = new CarScatterPlot(cars);
        root.setCenter(carScatterPlot.getChart());
    }
    /**
     * request a user-input file
     * @param stage is parent window for the dialogue
     * @return the File representing our data file
     */
    private static File getFileFromUser(Stage stage){
        File fileChosen = null;

        //Init a FileChooser and provide it a location where we want to grab out file
        FileChooser fileChooser = new FileChooser();

        //only show csv files within our resources directory
        fileChooser.setInitialDirectory(new File("src/main/resources"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );

        fileChosen = fileChooser.showOpenDialog(stage);

        return fileChosen;


    }

    private void readAutoMpgFile(File file) {
        cars = new ArrayList<>();
        try (Scanner sc = new Scanner(file)){
            //skip header
            sc.nextLine();

            while(sc.hasNextLine()) {
                Car car = new Car(sc.nextLine().strip());
                cars.add(car);
            }

        }
        catch (FileNotFoundException e) {
            System.err.println("If you're reading this then there is something HORRIBLY wrong with this code!");
            System.exit(1);
        }
    }
}
