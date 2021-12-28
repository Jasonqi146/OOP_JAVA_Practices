import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color; 
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class ShowImage extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        VBox v = new VBox(10);
        v.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, ), CornerRadii.EMPTY, Insets.EMPTY)));
        Rectangle r1 = new Rectangle(40,40);
        Rectangle r2 = new Rectangle(40,40);
        Rectangle r3 = new Rectangle(40,40);
        Rectangle r4 = new Rectangle(40,40);
        Rectangle r5 = new Rectangle(40,40);
        Rectangle r6 = new Rectangle(40,40);
        Rectangle r7 = new Rectangle(40,40);
        Rectangle r8 = new Rectangle(40,40);
        Rectangle r9 = new Rectangle(40,40);
        Rectangle r10 = new Rectangle(40,40);
        Rectangle r11 = new Rectangle(40,40);
        Rectangle r12 = new Rectangle(40,40);
        r1.setFill(Color.BROWN);
        r2.setFill(Color.BROWN);
        r3.setFill(Color.BROWN);
        r4.setFill(Color.BROWN);
        r5.setFill(Color.BROWN);
        r6.setFill(Color.BROWN);
        r7.setFill(Color.BROWN);
        r8.setFill(Color.BROWN);
        r9.setFill(Color.BROWN);
        r10.setFill(Color.BROWN);
        r11.setFill(Color.BROWN);
        r12.setFill(Color.BROWN);
        HBox h1 = new HBox(10);
        HBox h2 = new HBox(10);
        HBox h3 = new HBox(10);
        HBox h3 = new HBox(10);
        h1.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, ), CornerRadii.EMPTY, Insets.EMPTY)));
        h2.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, ), CornerRadii.EMPTY, Insets.EMPTY)));
        h3.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, ), CornerRadii.EMPTY, Insets.EMPTY)));
        h4.setBackground(new Background(new BackgroundFill(Color.rgb(0, 100, ), CornerRadii.EMPTY, Insets.EMPTY)));
        h1.getChildren().addAll(r1, r2, r3);
        h2.getChildren().addAll(r4, r5, r6);
        h3.getChildren().addAll(r7, r8, r9);
        h4.getChildren().addAll(r10, r11, r12);
        v.getChildren().addAll(h1,h2,h3,h4);

        // Create A scene and place it in the stage
        Scene scene = new Scene(pane);
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
