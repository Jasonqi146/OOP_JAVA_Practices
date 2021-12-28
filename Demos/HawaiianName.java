//"I worked on the homework assignment alone, using only course materials."
import java.util.Scanner;
public class HawaiianName{

	public static void main(String[] args){
		System.out.println("Welcome to Hawaii! Let's check if your name is Hawaiian enough.\n");
		Scanner myScanner = new Scanner(System.in);
		String theQuestion = "y";
		while(theQuestion.equals("y")){
		System.out.print("Enter your name:");
		String inputName = myScanner.next();
		int charPos = 0;
		char nextChar = inputName.charAt(charPos);
		String newName = "";
		while(charPos < inputName.length()){
			if(nextChar =='a' ||nextChar =='e'||nextChar =='i'||nextChar =='o'||nextChar =='u'||nextChar =='k'
			||nextChar =='l'||nextChar =='h'||nextChar =='m'||nextChar =='n'||nextChar =='A'||nextChar =='E'
			||nextChar =='I'||nextChar =='O'||nextChar =='U'||nextChar =='K'||nextChar =='L'||nextChar =='H'
			||nextChar =='M'||nextChar =='N'){
				newName += nextChar;
			}else;
			charPos++;
			if(charPos!=inputName.length())
			nextChar = inputName.charAt(charPos);
		}
		if(charPos==newName.length()){
			System.out.println("Aloha, "+newName);
		}else{
			System.out.println("Sorry "+inputName+", you aren’t Hawaiian enough to come!");
			System.out.println("Let’s make your name... "+newName+"!");
			System.out.println("Aloha, "+newName);
		}
		System.out.print("Would you to try again? (y/n):");
		theQuestion = myScanner.next();
		System.out.println();
		}
	}
}