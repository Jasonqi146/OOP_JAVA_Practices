/**
 * Representing a restaurant.
 * @author Zhengyang Qi
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private int numReviews;

    /**
     * Construct a restaurant.
     * @param name the name of the restaurant.
     * @param numReviews the number of reviews recieved by it.
     */
    public Restaurant(String name, int numReviews) {
        this.name = name;
        this.numReviews = numReviews;
    }

    /**
     * Get the name of the restaurant.
     * @return its name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the number of reviews recieved by this restaurant.
     * @return the number of reviews
     */
    public int getNumReviews() {
        return numReviews;
    }


}