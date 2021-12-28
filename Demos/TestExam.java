import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
public class TestExam {
	public static void main(String[] args){
		System.out.println("dafs");
		throw new IOException();
	}
	static int guessTheOutput(int first, int second) {
		if(first == 0) {
			return 0;
		} else {
			return guessTheOutput(first/second, second) + 1;
		}
	}
}
