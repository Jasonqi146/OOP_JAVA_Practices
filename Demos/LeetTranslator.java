//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
public class LeetTranslator{

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		String toTranslate = scan.nextLine();
		toTranslate=toTranslate.toLowerCase();
		toTranslate=toTranslate.replace("a","@");
		toTranslate=toTranslate.replace("e","3");
		toTranslate=toTranslate.replace("i","1");
		toTranslate=toTranslate.replace("s","$");
		toTranslate=toTranslate.replace("o","0");
		System.out.println(toTranslate);
	}
}