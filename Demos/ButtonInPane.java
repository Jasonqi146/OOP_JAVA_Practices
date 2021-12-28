import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create A scene and place A button in the scene
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK"));
        pane.getChildren().add(new Label("Yo!"));
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Button in A pane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //what if we wanted another stage with A different button?
        /*
        Scene myScene = new Scene(new Button("Hello"), 200, 50);
        Stage myStage = new Stage();
        myStage.setScene(myScene);
        myStage.show();
        */
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
