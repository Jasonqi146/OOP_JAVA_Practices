import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * working with the Yelp “database” with different methods.
 * @author Zhengyang Qi
 * @version 1.0
 */

public class YelpDB {
    /**
     * Main method, running different methods.
     * @param args inputs after java YelpDB in console
     */
    public static void main(String[] args) {
        String restaurantName = args[0];
        String reviewName = args[1];
        File databaseRestaurants = new File("./database_restaurants");
        /*
        System.out.println("Is this a directory? " + databaseRestaurants.isDirectory());

        File[] files = database_restaurants.listFiles();
        for (File fileName : files) {
            if (fileName.isDirectory())
            System.out.println(fileName.getName());

        }
         */
        /*
        ArrayList<Restaurant> arr = load(databaseRestaurants);
        for (Restaurant r : arr) {
                System.out.println(r.getName());
        }
        for (Restaurant r : arr) {
            System.out.println(r.getNumReviews());
        }
        System.out.println(countNumReviews(arr));
         */
        try {
            System.out.println(readReview(databaseRestaurants, load(databaseRestaurants), "Chickfila", "Emma"));
            System.out.println(readReview(databaseRestaurants, load(databaseRestaurants), "Satto", "Neethu"));
        } catch (ReviewNotFoundException a) {
            a.printStackTrace();
        } catch (NotARestaurantException b) {
            b.printStackTrace();
        }
    }

    /**.
     * load the file information into an arraylist
     * @param f file being used
     * @return arraylist with restaurant information
     */
    public static ArrayList<Restaurant> load(File f) {
        ArrayList<Restaurant> arr = new ArrayList<>();
        loadHelper(f, arr);
        return arr;
    }

    /**.
     * loadHelper using a file and an arraylist to constructor a new arraylist
     * @param f file being used
     * @param arr import an arraylist of restaurant
     * @return arraylist of restaurant information
     */

    public static ArrayList<Restaurant> loadHelper(File f, ArrayList<Restaurant> arr) {
        if (f.isDirectory()
                && !(f.getName().length() >= 10
                && f.getName().substring(0, 10).equals("restaurant"))) {
            File[] files = f.listFiles();
            ArrayList<File> arrFiles = new ArrayList<File>();
            for (File ff: files) {
                if (ff.isDirectory()) {
                    arrFiles.add(ff);
                }
            }
            for (File ff: arrFiles) {
                loadHelper(ff, arr);
            }
            //((f.getName().length() >= 10
            //                    && f.getName().substring(0,10).equals("restaurant")))
        } else if ((f.getName().length() >= 10
                && f.getName().substring(0, 10).equals("restaurant"))) {
            Restaurant r = new Restaurant(f.getName().substring(10),
                    f.list().length);
            arr.add(r);
            return arr;
        }
        return arr;
    }

    /**.
     * count the total number of review of all the restaurants in the arraylist
     * @param arr arraylist with restaurant information stored
     * @return total number of restaurant reviews in the arraylist
     */


    public static int countNumReviews(ArrayList<Restaurant> arr) {
        int count = 0;
        for (Restaurant r : arr) {
            count += r.getNumReviews();
        }
        return count;
    }

    /**
     * Get the review score given by a reviewer of a restaurant from an arraylist.
     * @param f a file to start with
     * @param arr an array of restaurants
     * @param restaurantName the restaurant name we are looking for
     * @param reviewName the review name we are looking for
     * @return the rating of the review we are looking for
     * @throws ReviewNotFoundException exception when the review is not found
     */

    public static double readReview(File f, ArrayList<Restaurant> arr,
                                 String restaurantName, String
                                         reviewName) throws ReviewNotFoundException {
        boolean restaurantExists = false;
        for (Restaurant r : arr) {
            if (r.getName().equals(restaurantName)) {
                restaurantExists = true;
            }
        }
        if (!restaurantExists) {
            throw new NotARestaurantException();
        } else {
            if (f.isDirectory()
                    && !(f.getName().length() >= 10
                    && f.getName().substring(10).equals(restaurantName))) {
                File[] files = f.listFiles();
                ArrayList<File> arrFiles = new ArrayList<File>();
                for (File ff: files) {
                    if (ff.isDirectory()) {
                        arrFiles.add(ff);
                    }
                }
                double[] storage = new double[arrFiles.size()];
                for (int i = 0; i < arrFiles.size(); i++) {
                    storage[i] = readReview(arrFiles.get(i), arr, restaurantName, reviewName);
                }
                for (double d : storage) {
                    if (d != 0.0) {
                        return d;
                    }
                }
            } else if (f.getName().length() >= 10
                    && f.getName().substring(10).equals(restaurantName)) {
                boolean reviewExists = false;
                for (File ff : f.listFiles()) {
                    String s = ff.getName().substring(6);
                    if (s.substring(0, s.length() - 4).equals(reviewName)) {
                        try {
                            reviewExists = true;
                            Scanner myScan = new Scanner(ff);
                            myScan.nextLine();
                            myScan.nextLine();
                            myScan.next();
                            return myScan.nextDouble();
                        } catch (FileNotFoundException fnfe) {
                            return 0.0;
                        }
                    }
                }
                if (!reviewExists) {
                    throw new ReviewNotFoundException(reviewName);
                }
            }
        }
        return 0.0;
    }
}