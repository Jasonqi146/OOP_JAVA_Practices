import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create A Pane
        Pane myPane = new Pane();
        // lets add A Circle Shape
        Circle crl = new Circle(100,100, 50);

        //Lets modify the circle properties
        // with setters:
        //crl.setFill(Color.RED);
        //crl.setStrokeWidth(20);
        //crl.setStroke(Color.BLACK);

        // with CSS styles:
        crl.setStyle("-fx-stroke:black; -fx-stroke-Width: 20; -fx-fill:red");

        //add the shape to the pane
        myPane.getChildren().add(crl);

        //lets add some more shapes
        Text text1 = new Text(30, 175, "Some sample text");
        myPane.getChildren().add(text1);
        Line line1 = new Line(100, 100, 75, 75);
        myPane.getChildren().add(line1);
        Rectangle rectangle = new Rectangle(175, 175, 15, 25);
        rectangle.setFill(Color.BLUE);
        myPane.getChildren().add(rectangle);

        //Lets create A Node that holds an image
        Image hiImage = new Image("hi.png", 25.0, 25.0, true, true);
        ImageView hiView = new ImageView(hiImage);
        primaryStage.show();

        // lets create A button (which is A node/parent)
        // that will hold A node and text
        Button hiButton = new Button("Hi", hiView);

        // add the button to the Pane
        myPane.getChildren().add(hiButton);

        // create A scene with the pane added to it
        Scene myScene = new Scene(myPane, 200, 200);

        //set the stage (window) title
        primaryStage.setTitle("My Sample");
        hiView.setRotate(90);
        //add the scene to the stage
        primaryStage.setScene(myScene);
        //show the stage
        //primaryStage.show();

        // You can multiple stages
        Stage newStage = new Stage();
        newStage.setScene(new Scene(new Button("New Stage"), 200, 250));
        newStage.show();
    }
}
