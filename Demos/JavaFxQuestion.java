// assume all necessary imports are included and correct
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.geometry.Pos;

public class JavaFxQuestion extends Application {
private VBox vPane = new VBox (25.0);

@Override
public void start ( Stage primaryStage ) throws Exception {
Rectangle rectangle = new Rectangle(100 , 100);
vPane.getChildren (). add( rectangle );
vPane.setAlignment(Pos.CENTER);

Button myButton = new Button (" Click Me");
myButton.setOnAction (new ButtonHandler ());
vPane.getChildren (). add( myButton );

Scene myScene = new Scene (vPane , 300 , 300);
primaryStage.setScene ( myScene );
primaryStage.show();
}

class ButtonHandler implements EventHandler < ActionEvent > {
@Override
public void handle ( ActionEvent event ) {
Node firstNode = vPane . getChildren (). get (0);
// setRotate ( double rotateDegrees )
firstNode . setRotate ( firstNode . getRotate () + 45.0);
}
}

}