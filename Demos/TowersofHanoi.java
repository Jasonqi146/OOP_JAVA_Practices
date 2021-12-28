import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;  

public class TowersofHanoi extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {
      //Already done for you            
      Text t1 = new Text(100, 30, "The Towers of Hanoi");
      t1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

      //Create the base of the poles with top left at (30, 170)
      //width 340 height 10 

      //Create 3 poles (lines) at x: 105, x: 200, x: 295.
      //All poles begin at y: 170 and end at y: 60

      //Blue rectangle w/ top left at (60, 140)
      //Width 90, height 30
      //Use .setFill(Color color) method

      //Green rectangle w/ top left at (70, 110)
      //Width 70, height 30

      //Red rectangle w/ top left at (80, 80)
      //width 50, height 30

      //Create a Group object and add all nodes to it   
               
      //Create a scene object with size 400 by 200 that contains the group object

      //Set title of stage to "Recitation 11"
         
      //Add scene to the stage 
         
      //Display the contents of the stage 

   }    
   public static void main(String args[]){    
      //start the program!      
       
   }         
} 