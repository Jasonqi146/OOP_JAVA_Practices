//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.util.Random;

public class CoinFlip {
    public static void main(String[] args) {
        Boolean theQuestion = true;
        Scanner sc = new Scanner(System.in);
        while (theQuestion) {
            while (1 == 1) {
                System.out.print("Ready to run a coin flip simulation. Enter the number of sequences: ");
                int numSequence = sc.nextInt();
                if (numSequence < 0) {
                    break;
                }
                System.out.print("How many heads should each sequence have? ");
                int numHeads = sc.nextInt();
                if (numHeads < 0) {
                    break;
                }
                System.out.print("How many tails should each sequence have? ");
                int numTails = sc.nextInt();
                if (numTails < 0) {
                    break;
                }
                System.out.println("Simulating Sequences");
                //simulation
                int totalFlips = 0;
                int maxFlips = 0;
                Random rd = new Random();
                for (int i = 0; i < numSequence; i++) {
                    int headsNow = 0;
                    int tailsNow = 0;
                    int numFlips = 0;
                    String outcome = "";
                    while (headsNow < numHeads || tailsNow < numTails) {
                        totalFlips++;
                        numFlips++;
                        int a = rd.nextInt(2);
                        if (a == 0) {
                            headsNow++;
                            outcome += "H";
                        } else {
                            tailsNow++;
                            outcome += "T";
                        }
                    }
                    if (numFlips > maxFlips) {
                        maxFlips = numFlips;
                    }
                    System.out.println((i + 1) + " - " + outcome);
                }
                System.out.println("The average number of flips was "
                    + (double) totalFlips / numSequence + " and maximum was " + maxFlips);
                break;
            }
            //whether continue
            Boolean whetherContinue = true;
            while (whetherContinue) {
                System.out.print("\n" + "Would you like to run another simulation? (y/n): ");
                String a = sc.next();
                if (a.equals("y")) {
                    whetherContinue = false;
                    System.out.println();
                } else if (a.equals("n")) {
                    whetherContinue = false;
                    theQuestion = false;
                }
            }
        }
    }
}