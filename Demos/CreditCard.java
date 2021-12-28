/**
* 1. You are given a class called CreditCard.
*
* 2. Create the following instance fields: a String called name,
* a double called moneySpent, and a boolean called inDebt.
* Set their visibility modifier as discussed in class for
* instance data.
//instance data
*
* 3. Make two constructors. One will take in 3 parameters for each of the
* instance variables in the order listed above. The second should take in 1
* parameter for name and set moneySpent to 0.0 and inDebt to false.
*
* 4. Create a method called spendMoney that takes in a double called amount
* that returns nothing. This method should increase moneySpent by this amount
* and set inDebt to true.
*/

//java is passed by value
public class CreditCard {

    private String name;
    private double moneySpent;
    private boolean inDebt;
    private boolean shit;

    public CreditCard(String name, double moneySpent, boolean inDebt) {
        this.name = name;
        this.moneySpent = moneySpent;
        this.inDebt = inDebt;
    }
    public CreditCard(String name) {
        // this.name = name;
        // this.moneySpent = 0.0;//for primatives, can use default, for classes, exception
        // this.inDebt = false;
        this(name, 0.0, false);
        System.out.println(this);
    }
    public CreditCard(boolean inDebt) {
        this("", 0.0, inDebt);
        inDebt = true;
    }
    public CreditCard() {
        this(false);
        System.out.println(this);
    }

    public double spendMoney(double amount) {
        this.moneySpent += amount;
        this.inDebt = true;
        return moneySpent;
    }

    public static void main(String[] args) {
        //CreditCard creditCard = new CreditCard();
        //not legal bc, there is no no-arg constructor (the default goes away);
        CreditCard creditCard = new CreditCard("money");
        double currentMoneySpent = creditCard.spendMoney(70.00);
        System.out.println(creditCard.name + ": " + creditCard.moneySpent + " - " + creditCard.inDebt);
        CreditCard card = new CreditCard();
        System.out.println(creditCard.inDebt);
        System.out.println(card);
    }
    //this method tells java what to execute if we try to print out the object
    public String toString() {
        return this.name + ": " + this.moneySpent + "- " + this.inDebt;
    }
//aliasing
}
