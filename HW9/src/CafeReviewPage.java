/*
In order to help learn course concepts, I worked on the homework with [give the names of the people you
worked with], discussed homework topics and issues with Jinghong Peng, and/or consulted related
material that can be found at [cite any other materials not provided as course materials for CS 1331 that
assisted your learning].
*/
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
import javafx.scene.Node;

/**
 * Representing a Cafe review page.
 * @author Zhengyang Qi
 * @version 1.0
 */
public class CafeReviewPage extends Application {
    /**
     * Main method, running different methods.
     * @param args inputs after java CafeReviewPage in console
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cafe1331 Reviews");
        VBox v = new VBox();
        HBox h = new HBox(0);
        h.setPrefSize(470, 25);
        TextFlow output = new TextFlow();
        output.setPrefHeight(470);
        TextField name = new TextField();
        name.setPromptText("Name");
        name.setPrefWidth(110);
        TextField feedback = new TextField();
        feedback.setPromptText("Feedback");
        feedback.setPrefWidth(110);
        TextField color = new TextField();
        color.setPromptText("Color");
        color.setPrefWidth(110);
        Button bt = new Button("Post");
        bt.setPrefWidth(70);
        Button cbt = new Button("Clear");
        cbt.setPrefWidth(70);
        h.getChildren().addAll(name, feedback, color, bt, cbt);
        v.getChildren().addAll(output, h);
        Scene scene = new Scene(v, 470, 425);
        primaryStage.setScene(scene);
        primaryStage.show();

        cbt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                output.getChildren().clear();
            }
        });
        bt.setOnAction(new EventHandler<ActionEvent>() {
            class A {
                
            }
            public void handle(ActionEvent event) {
                String inputName = name.getText();
                String inputFeedback = feedback.getText();
                String inputColor = color.getText();
                Text t = new Text();
                if (!inputFeedback.equals("")) {
                    if (!inputName.equals("")) {
                        String comment = inputName + ":"
                                + "\n" + inputFeedback + "\n" + "\n";
                        t = new Text(comment);
                    } else {
                        String comment = "Anonymous:"
                                + "\n" + inputFeedback + "\n" + "\n";
                        t = new Text(comment);
                    }
                    t.setFont(Font.font("Verdana", 15));
                    try {
                        if (!inputColor.equals("")) {
                            t.setStyle("-fx-fill: " + color.getText().toUpperCase() + ";-fx-font-weight:normal;");
                        }
                    } catch (Exception e) { }
                }
                output.getChildren().add(t);
            }
        });
    }
}
