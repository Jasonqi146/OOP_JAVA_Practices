/*
In order to help learn course concepts, I worked on the homework with [give the names of the people you
worked with], discussed homework topics and issues with Jinghong Peng, and/or consulted related
material that can be found at [cite any other materials not provided as course materials for CS 1331 that
assisted your learning].
*/
import javafx.application.Application;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class FelipeSaysCompleted extends Application {

    private Text command = new Text("");

    // Keep track of commands
    private ArrayList<FelipeCommand> felipeCommands = new ArrayList<FelipeCommand>();
    private int correctGuesses = 0;

    @Override
    public void start(Stage primaryStage) {

        // Update the commands in the Text Field (I recommend making a new method)
        updateCommandText();

        // Images
        ImageView leftImage = new ImageView(new Image("./Left.png"));
        leftImage.setFitWidth(180);
        leftImage.setFitHeight(180);
        ImageView rightImage = new ImageView(new Image("./Right.png"));
        rightImage.setFitWidth(180);
        rightImage.setFitHeight(180);
        ImageView mouseImage = new ImageView(new Image("./Click.png"));
        mouseImage.setFitWidth(180);
        mouseImage.setFitHeight(180);
        ImageView buttonImage = new ImageView(new Image("./Button.png"));
        buttonImage.setFitWidth(180);
        buttonImage.setFitHeight(180);

        // Click me Button
        Button button = new Button("Click Me");

        // Layout the elements to match the picture
        HBox h = new HBox(50);
        h.getChildren().addAll(leftImage, rightImage, mouseImage, buttonImage);
        h.setAlignment(Pos.CENTER);

        VBox v = new VBox(20);
        v.getChildren().addAll(command, button, h);
        v.setAlignment(Pos.CENTER);

        // Add elements to a scene
        Scene scene = new Scene(v, 900, 300);

        v.requestFocus();

        // Button event handler. Check to see if this is the
        // correct input. Pulse the node if it is, otherwise get
        // a new set of commands
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                checkInput(FelipeCommand.BUTTON_PRESS);
                pulseNode(buttonImage);
                v.requestFocus();
            }
        });

        // Mouse click event handler. If the click is a left click,
        // check to see if this is the correct input. Pulse the node
        // if it is, otherwise get a new set of commands
        v.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                checkInput(FelipeCommand.MOUSE_CLICK);
                pulseNode(mouseImage);
            }
        });

        // Keyboard event handler. If the key pressed is Left or Right,
        // check to see if this is the correct input. Pulse the node
        // if it is, otherwise get a new set of commands
        v.setOnKeyPressed(new KeyHandler(leftImage, rightImage));

        //Add scene to the stage
        primaryStage.setScene(scene);

        //Display the contents of the stage
        primaryStage.show();
    }

    public class KeyHandler implements EventHandler<KeyEvent> {

        private ImageView leftImage;
        private ImageView rightImage;

        public KeyHandler(ImageView leftImage, ImageView rightImage) {
            this.leftImage = leftImage;
            this.rightImage = rightImage;
        }

        public void handle(KeyEvent e) {
            System.out.println("Key pressed: " + e.getCode());
            switch (e.getCode()) {
                case LEFT:
                    checkInput(FelipeCommand.KEY_LEFT);
                    pulseNode(leftImage);
                    break;
                case RIGHT:
                    checkInput(FelipeCommand.KEY_RIGHT);
                    pulseNode(rightImage);
                    break;
                default:
                    System.out.println("Unknown");
            }
        }
    }

    public void updateCommandText() {
        updateCommands();
        command.setText(felipeCommands.toString());
        showAndFadeNode(command);
    }

    public void checkInput(FelipeCommand felipeCommand) {
        if (felipeCommand == felipeCommands.get(correctGuesses)) {
            System.out.println("Correct input");
            correctGuesses++;

            if (correctGuesses >= felipeCommands.size()) {
                System.out.println("new letter");
                updateCommandText();
                correctGuesses = 0;
            }
        } else {
            System.out.println("Failed");
            correctGuesses = 0;
            felipeCommands.clear();
            updateCommandText();
        }
    }

    /*
     * PROVIDED CODE
     * NO NEED TO MODIFY
     */

    public static void main(String[] args) {
        //start the program!
        launch(args);
    }

    /**
     * Chooses the next command and adds it to felipeCommands
     */
    public void updateCommands() {
        felipeCommands.add(FelipeCommand.values()[(int) (Math.random() * FelipeCommand.values().length)]);
    }

    /**
     * Shows a node and then fades it out
     * @param n The node to show and then fade
     */
    public void showAndFadeNode(Node n) {
        //Instantiating FadeTransition class
        FadeTransition fade = new FadeTransition();

        //setting the duration for the Fade transition
        fade.setDuration(Duration.millis(4000));

        //setting the initial and the target opacity value for the transition
        fade.setFromValue(10);
        fade.setToValue(0);

        //setting cycle count for the Fade transition
        fade.setCycleCount(1);

        //the transition will set to be auto reversed by setting this to true
        fade.setAutoReverse(false);

        fade.setNode(n);

        //playing the transition
        fade.play();
    }

    /**
     * Pulses a node
     * @param n The node to pulse
     */
    public void pulseNode(Node n) {
        ScaleTransition st = new ScaleTransition(Duration.millis(700), n);
        st.setByX(1.001f);
        st.setByY(1.001f);

        st.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                n.setScaleX(1);
                n.setScaleY(1);
            }
        });

        st.play();
    }
}
