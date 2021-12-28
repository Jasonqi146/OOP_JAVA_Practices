/**
* A representation of a cheeseconnoisseur.

*@author Zhengyang Qi
*@version 1.0
*/

public class CheeseConnoisseur {
    private String name;
    private Cheese myCheese;
    private int money;

    /**
    *Constructor to create a cheeseconnoisseur.
    *@param name String representing name of the cheeseconnoisseur
    *@param myCheese Cheese representing cheese
    *@param money int representing the money of the CheeseConnoisseur
    */
    public CheeseConnoisseur(String name, Cheese myCheese, int money) {
        this.name = name;
        this.myCheese = myCheese;
        this.money = money;
    }
    /**
    *Constructor to create a cheeseconnoisseur.
    *@param name String representing name of the cheeseconnoisseur
    *@param money int representing the money of the CheeseConnoisseur
    */
    public CheeseConnoisseur(String name, int money) {
        this(name, null, money);
    }
    /**
    *Constructor to create a cheeseconnoisseur.
    *@param name String representing name of the cheeseconnoisseur
    */
    public CheeseConnoisseur(String name) {
        this(name, null, 0);
    }
    /**
    *Constructor to create a cheeseconnoisseur.
    */
    public CheeseConnoisseur() {
        this("K", null, 20);
    }
    /**
    *trade a new cheese with the CheeseConnoisseur.
    *@param newCheese Cheese a specific cheese
    */
    public void cheeseTrade(Cheese newCheese) {
        myCheese.trade();
        newCheese.trade();
        this.myCheese = newCheese;
    }
    /**
    *two CheeseConnoisseurs trade cheeses.
    *@param bob CheeseConnoisseur set a new CheeseConnoisseur
    */
    public void cheeseTrade(CheeseConnoisseur bob) {
        if (this.myCheese == null || bob.myCheese == null) {
            return;
        } else if (this.myCheese.equals(bob.getMyCheese())) {
            return;
        } else {
            if (this.myCheese.getPrice() > bob.getMyCheese().getPrice()) {
                int difference = this.myCheese.getPrice() - bob.getMyCheese().getPrice();
                if (difference > bob.money) {
                    return;
                }
                bob.setMoney(bob.getMoney() - difference);
                this.money += difference;
                Cheese cheeseOnTheCounter = this.myCheese;
                this.cheeseTrade(bob.getMyCheese());
                bob.setMyCheese(cheeseOnTheCounter);
            } else {
                int difference = bob.getMyCheese().getPrice() - this.myCheese.getPrice();
                if (difference > this.money) {
                    return;
                }
                this.money -= difference;
                bob.setMoney(bob.getMoney() + difference);
                Cheese cheeseOnTheCounter = this.myCheese;
                this.cheeseTrade(bob.getMyCheese());
                bob.setMyCheese(cheeseOnTheCounter);
            }
        }
    }
    /**
    *get the name of the cheesesconnoisseur.
    *@return return the name of cheeseconnoisseur
    */
    public String getName() {
        return name;
    }
    /**
    *get the specific type of the cheeses.
    *@return return the specific cheese
    */
    public Cheese getMyCheese() {
        return myCheese;
    }
    /**
    *get the money of the CheeseConnoisseur.
    *@return return the money of CheeseConnoisseur
    */
    public int getMoney() {
        return money;
    }
    /**
    *set the name of the CheeseConnoisseur.
    *@param newName of the CheeseConnoisseur
    */
    public void setName(String newName) {
        this.name = newName;
    }
    /**
    *set the specific cheese of the CheeseConnoisseur.
    *@param newCheese Cheese of a specific type
    */
    public void setMyCheese(Cheese newCheese) {
        this.myCheese = newCheese;
    }
    /**
    *set the money of the CheeseConnoisseur.
    *@param newMoney money of the CheeseConnoisseur
    */
    public void setMoney(int newMoney) {
        this.money = newMoney;
    }



}
