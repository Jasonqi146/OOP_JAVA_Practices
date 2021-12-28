//In order to help learn course concepts,
//I worked on the homework with Jinghong Peng,
//discussed homework topics and issues with Jinghong Peng,
//and/or consulted related material that can be found at
//[cite any other materials not provided as course materials for CS 1331 that
//assisted your learning].

/**
* A representation of an animal.
*
* @author Zhengyang Qi
* @version 1.0
*/
public class CheeseDriver {
/**
* Main method; serves as the driver for our class.
*
* @param args String array representing arguments passed by command line
*/
    public static void main(String[] args) {
        Cheese american = new Cheese(30, "American", 2);
        Cheese parm = new Cheese(20, "Parm");
        Cheese cheddar = new Cheese(10, "Cheddar");
        Cheese blue = new Cheese(20, "Blue", 2);
        Cheese anotherBlue = new Cheese(20, "Blue", 2);

        CheeseConnoisseur bob = new CheeseConnoisseur("Bob", american, 30);
        CheeseConnoisseur john = new CheeseConnoisseur("John", 10);
        CheeseConnoisseur henry = new CheeseConnoisseur();
        CheeseConnoisseur adrian = new CheeseConnoisseur("Adrian", blue, 9);
        CheeseConnoisseur adriana = new CheeseConnoisseur("Adriana", anotherBlue, 4);
        CheeseConnoisseur edison = new CheeseConnoisseur("Edison", american, 50);
        CheeseConnoisseur epson = new CheeseConnoisseur("Epson", cheddar, 60);
        CheeseConnoisseur pete = new CheeseConnoisseur("Pete", blue, 200);
        CheeseConnoisseur fye = new CheeseConnoisseur("Fye", parm, 80);

        //Testing
        //two null
        /*
        Henry.CheeseTrade(John);
        System.out.println(Henry.getMyCheese());
        System.out.println(John.getMyCheese());
        */
        //one null
        /*
        Henry.CheeseTrade(Bob);
        System.out.println(Henry.getMyCheese());
        System.out.println(Bob.getMyCheese());
        */
        //two cheese equal
        /*
        Adrian.CheeseTrade(Adriana);
        System.out.println(Adrian.getMyCheese());
        System.out.println(Adriana.getMyCheese());
        */
        //if trader 1 is poor
        /*
        Adrian.CheeseTrade(Bob);
        System.out.println(Adrian.getMyCheese());
        System.out.println(Bob.getMyCheese());
        */
        //if trader 2 is poor
        /*
        Bob.CheeseTrade(Adriana);
        System.out.println(Adriana.getMyCheese());
        System.out.println(Bob.getMyCheese());
        */
        //success cases
        edison.cheeseTrade(epson);
        System.out.println(edison.getMyCheese());
        System.out.println(epson.getMyCheese());
        System.out.println(edison.getMyCheese().getPrice());
        System.out.println(epson.getMyCheese().getPrice());
        System.out.println(edison.getMoney());
        System.out.println(epson.getMoney());
        pete.cheeseTrade(edison);
        System.out.println(pete.getMyCheese());
        System.out.println(edison.getMyCheese());
        System.out.println(pete.getMyCheese().getPrice());
        System.out.println(edison.getMyCheese().getPrice());
        System.out.println(pete.getMoney());
        System.out.println(edison.getMoney());
        fye.cheeseTrade(pete);
        System.out.println(fye.getMyCheese());
        System.out.println(pete.getMyCheese());
        System.out.println(fye.getMyCheese().getPrice());
        System.out.println(pete.getMyCheese().getPrice());
        System.out.println(fye.getMoney());
        System.out.println(pete.getMoney());
    }
}