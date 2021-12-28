import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;

public class MouseEventDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        BorderPane pane = new BorderPane();
        Pane textPane = new Pane();
        Text text = new Text(20, 20, "Programming is fun");
        textPane.getChildren().add(text);
        pane.setCenter(textPane);
        // set an mouse event handler to move the text field
        // when the mouse button is pressed and dragged
        text.setOnMouseDragged((MouseEvent e) -> {
            text.setX(e.getX());
            text.setY(e.getY());
            System.out.println("getX(): " + e.getX() + " - getY: " + e.getY());
        });


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("MouseEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
} 

