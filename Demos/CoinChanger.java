import java.util.Scanner;

public class CoinChanger{

	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);  
    System.out.print("Pennis: ");
    int Pennies = scan.nextInt();  
    System.out.print("Nickels: ");
    int Nickels = scan.nextInt();
    System.out.print("Dimes: ");
    int Dimes = scan.nextInt(); 
    System.out.print("Quarters: ");
    int Quarters = scan.nextInt();
		int totalValCents = Pennies+Nickels*5+Dimes*10+Quarters*25;
		int dollars=totalValCents/100;
		int cents=totalValCents%100;
		System.out.println("Total is "+dollars+" dollars and "+cents+" cents.");
	}
}