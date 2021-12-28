/**
 * A representation of a cheese.

 * @author Zhengyang Qi
 * @version 1.0
 */

public class Cheese {
    private String type;
    private int price;
    private boolean sentient;
    private int count;
    private static int countall;

    /**
     * Constructor to create a cheese.
     *
     * @param price int representing price of cheese
     * @param type String representing name of the cheese
     * @param count int representing the trade number of this cheese
     */
    public Cheese(int price, String type, int count) {
        this.price = price;
        this.type = type;
        this.count = count;

        if (count >= 3) {
            this.sentient = true;
        } else {
            this.sentient = false;
        }
    }

    /**
     * Another constructor to create a cheese.
     *
     * @param price int representing price of cheese
     * @param type String representing name of the cheese
     */
    public Cheese(int price, String type) {
        this.price = price;
        this.type = type;
        this.sentient = false;
        this.count = 0;
    }

    /**
     * String representation of a cheese, accessed when printing cheese.
     *
     * @return String holding cheesename, trade count, and sentient or not.
     */
    public String toString() {
        if (sentient) {
            return "I am a slice of " + type + " cheese that has been traded " + count + " times.";
        } else {
            return "This is a slice of " + type + " cheese that has been traded " + count + " times.";
        }
    }

    /**
     * Check if two cheeses are equal.
     *
     * @param a is another cheese.
     * @return true if two cheeses have the same name, price and sentient, vis versa.
     */
    public boolean equals(Cheese a) {
        return (type.equals(a.getType())) && (price == a.getPrice()) && (sentient == a.getSentient());
    }

    /**
     * This cheese is traded.
     */
    public void trade() {
        if (++count == 3) {
            price *= 2;
            System.out.println("I’m ALIIIIIVE!");
        }
        countall++;
    }

    /**
     * Get the type of the cheese.
     *
     *@return the type of this cheese
     */
    public String getType() {
        return type;
    }

    /**
     * Get the price of the cheese.
     *
     *@return the price of the cheese
     */
    public int getPrice() {
        return price;
    }
    /**
     * get the sentient of the cheese.
     *
     *@return sentient
     */
    public boolean getSentient() {
        return sentient;
    }
    /**
     * get the count of trades of the cheese.
     *
     *@return count
     */
    public int getCount() {
        return count;
    }
    /**
     * get the total count of all trades across the cheeses.
     *
     *@return countall
     */
    public static int getCountall() {
        return countall;
    }
    /**
     * set the type of the cheeses.
     * @param newType String of the cheeses
     */
    public void setType(String newType) {
        this.type = newType;
    }
    /**
     * set the price of the cheeses.
     * @param newPrice of the cheeses
     */
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

}
