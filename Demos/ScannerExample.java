import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Insert your name and lastname: ");
        String name = sc.next();
        String lastname = sc.next();
        System.out.print("Insert the first int: ");
        int i = sc.nextInt();
        System.out.print("Insert the second int: ");
        int j = sc.nextInt();
        //can't do Scanner.nextInt();
        System.out.print("Insert the double: ");
        double d = sc.nextDouble();

        double first = i/(double)j;
        int second = i%j;
        double third = d*second;
        int forth = (int)third;

        System.out.println(name.charAt(0) + ". " + lastname + ", your results are: ");
        System.out.println("\t" + first);
        System.out.println("\t" + second);
        System.out.println("\t" + third);
        System.out.println("\t" + forth);
    }
}
