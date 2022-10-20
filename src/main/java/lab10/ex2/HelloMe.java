/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/19/22* Time: 7:45 PM
 *
 * Project: csci205_labs
 * Package: lab10.ex2
 * Class: HelloMe
 *
 * Description:
 *
 *
 ****************************************
 */

package lab10.ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloMe extends Application {

    /**
     * our root for the scene graph
     */
    private VBox root;

    /**
     * our top pane within the root scene graph
     */
    private HBox topPane;

    /**
     * text field bubble
     */
    private TextField textFieldInputName;


    /**
     * Button instance variable
     */
    private Button btnHello;


    private Text textNameOutput;


    /**
     * initialize our scene graph container
     */
    private void initSceneGraph() {
        this.root = new VBox();
        this.root.setSpacing(10);
        this.root.setPadding(new Insets(15));
        this.root.setAlignment(Pos.CENTER);

        makeTopPaneScene();

        makeHelloButton();

        makeSeparator();

        makeOutputText();


    }
    private void makeTopPaneScene() {
        this.topPane = new HBox();
        this.topPane.setSpacing(10);
        this.topPane.setAlignment(Pos.CENTER);
        this.topPane.getChildren().add(new Label("Your name:"));
        makeInputField();
        root.getChildren().add(this.topPane);
    }

    private void makeOutputText() {
        this.textNameOutput = new Text();
        this.textNameOutput.setFont(Font.font(null, FontWeight.BOLD, 30));
        this.textNameOutput.setFill(Color.FUCHSIA);

        Reflection reflection = addReflection();

        addDropShadow(reflection);

        root.getChildren().add(textNameOutput);
    }

    private void addDropShadow(Reflection reflection) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setHeight(5);
        dropShadow.setRadius(2);
        dropShadow.setColor(Color.DARKGRAY);
        reflection.setInput(dropShadow);

        root.setOnMouseMoved(event -> {
            dropShadow.setOffsetX(event.getX()-root.getWidth()/3);
            dropShadow.setOffsetY(event.getY()-root.getWidth()/3);
        });
    }

    private Reflection addReflection() {
        Reflection reflection = new Reflection();
        reflection.setFraction(0.9);
        this.textNameOutput.setEffect(reflection);
        return reflection;
    }

    private void makeInputField() {
        this.textFieldInputName = new TextField();
        this.topPane.getChildren().add(this.textFieldInputName);
    }

    private void makeSeparator() {
        this.root.getChildren().add(new Separator());
    }

    private void makeHelloButton() {
        this.btnHello= new Button("Show my name!");
        this.btnHello.setOnAction(event -> {
            System.out.println("Hello, " + this.textFieldInputName.getText() + "!");
            this.textNameOutput.setText(this.textFieldInputName.getText());
        });
        this.root.getChildren().add(this.btnHello);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        initSceneGraph();

        primaryStage.setScene(new Scene(this.root));

        primaryStage.sizeToScene();

        primaryStage.setTitle("Hello, Me!");

        primaryStage.show();

    }
}
