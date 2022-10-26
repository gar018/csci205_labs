package lab10.trafficlightmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab10.trafficlightmvc.model.TrafficLightModel;
import lab10.trafficlightmvc.view.TrafficLightView;

public class TrafficLightMain extends Application {

    /** the reference to the Model */
    private TrafficLightModel theModel;

    /** the reference to the View */
    private TrafficLightView theView;

    /** the reference to the Controller */
    private TrafficLightController theController;

    /**
     * main method for the TrafficLight program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * init method for the TrafficLight program
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new TrafficLightModel();
        this.theView = new TrafficLightView(this.theModel);
        this.theController = new TrafficLightController(this.theView,this.theModel);

    }

    /**
     * the start method to the TrafficLight program
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(theView.getRoot());

        //Attach a CSS file for styling
        scene.getStylesheets().add(getClass().getResource("/lab10/trafficlightmvc.css").toExternalForm());

        primaryStage.setTitle("Traffic Light Sim");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }
}
