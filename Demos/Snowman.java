import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

public class Snowman extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        final int MID = 150;
        final int TOP = 50;

        Rectangle bgd = new Rectangle(0, 0, 300, 300);
        bgd.setFill(Color.CYAN);

        Text text = new Text(MID + 95, 20, "Frosty");
        text.setFont(
                Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));

        // ground
        Rectangle ground = new Rectangle(0, 175, 300, 50);
        ground.setFill(Color.BLUE);

        // sun
        Circle sun = new Circle(0, 0, 60);
        sun.setFill(Color.YELLOW);

        // head
        Ellipse head = new Ellipse(MID, TOP + 20, 20, 20);
        head.setFill(Color.WHITE);

        // upper torso
        Ellipse upper_torso = new Ellipse(MID, TOP + 60, 35, 25);
        upper_torso.setFill(Color.WHITE);

        // lower torso
        Ellipse lower_torso = new Ellipse(MID, TOP + 110, 50, 30);
        lower_torso.setFill(Color.WHITE);

        // left eye
        Ellipse lefteye = new Ellipse(MID - 8, TOP + 12, 3, 3);
        // right eye
        Ellipse righteye = new Ellipse(MID + 8, TOP + 12, 3, 3);

        // smile
        Arc smile = new Arc(MID, TOP + 25, 10, 5, 190, 160);
        smile.setType(ArcType.OPEN);

        // left arm
        Line leftarm = new Line(MID - 25, TOP + 60, MID - 50, TOP + 40);
        // right arm
        Line rightarm = new Line(MID + 25, TOP + 60, MID + 55, TOP + 60);

        // brim of hat
        Line hat_brim = new Line(MID - 20, TOP + 5, MID + 20, TOP + 5);
        // top of hat
        Rectangle hat_top = new Rectangle(MID - 15, TOP - 20, 30, 25);

        // Create A scene and place it in the stage
        Pane pane = new Pane();
        pane.getChildren().add(bgd);
        pane.getChildren().add(text);
        pane.getChildren().add(ground);
        pane.getChildren().add(sun);
        pane.getChildren().add(head);
        pane.getChildren().add(upper_torso);
        pane.getChildren().add(lower_torso);
        pane.getChildren().add(lefteye);
        pane.getChildren().add(righteye);
        pane.getChildren().add(leftarm);
        pane.getChildren().add(rightarm);
        pane.getChildren().add(smile);
        pane.getChildren().add(hat_brim);
        pane.getChildren().add(hat_top);

        Scene scene = new Scene(pane, 300, 200);
        // Set the stage title
        primaryStage.setTitle("Snowman");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
