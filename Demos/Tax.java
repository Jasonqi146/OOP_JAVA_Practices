public class Tax {



	public static void main(String[] args){
		String name = "Chad";
		int salary = 118000;
		double taxRate = 0.3;
		double income = salary*(1-taxRate);
		System.out.println(name+" is making $"+income+" dollars after tax!");
	}
}