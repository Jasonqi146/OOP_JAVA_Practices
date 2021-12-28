import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
public class FileIO {
	 public static void main ( String[] args ) {
 		try {
 			Scanner scan = new Scanner (new File ("text.txt"));
 			PrintWriter writer = new PrintWriter (" someFile . txt");
 			int num = 0;
 			while (scan.hasNextLine()){
 				num ++;
 				String str = scan.nextLine();
 				if (str.contains (" hello ")) {
 					writer.println (num + ": " + str.toUpperCase ());
 					writer.flush();
 				}
 			}
 		} catch(Exception ex){
 			System.out.println("pjh");
 		}
 	}
}