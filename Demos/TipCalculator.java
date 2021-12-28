import java.util.Scanner;

public class TipCalculator{

	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Welcome to Tip Calculator!\n");
		System.out.println("Enter the prices of your items. Enter -1 to enter tip percentage.");
		int itemNumber = 1;
		double subtotal = 0.0;
		double ItemPrice = 0;
		while(ItemPrice!=-1){
			System.out.print("Item "+itemNumber+": $");
			ItemPrice = myScanner.nextDouble();
			if (ItemPrice != -1){
				subtotal += ItemPrice;
				itemNumber++;
			}
		}
		System.out.print("\nEnter the tip percentage:");
		double tipPercentage = myScanner.nextDouble();
		System.out.println();
		System.out.println("Subtotal: $"+subtotal);
		System.out.println("Tip:      $"+Math.round(subtotal*tipPercentage * 100.0) / 100.0);
		System.out.println("Total:    $"+Math.round(subtotal*(1+tipPercentage) * 100.0) / 100.0);
	}
} 