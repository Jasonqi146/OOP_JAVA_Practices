// worked on the homework assignment alone, using only course materials.

import java.util.Scanner;

public class StandingCalculator{
	public static void main(String[] args){
		int credits;
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Credit hours taken:");
		credits = myScanner.nextInt();
		if(credits>=0&&credits<=29){
			System.out.println("Freshman");
		}
		else if(credits>=30&&credits<=59){
			System.out.println("Sophomore");
		}
		else if(credits>=60&&credits<=89){
			System.out.println("Junior");
		}
		else if(credits>=90){
			System.out.println("Senior");
		}
		else{
			System.out.println("Invalid");
		}
	}
}