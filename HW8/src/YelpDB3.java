import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class YelpDB3 {
    public static void main(String[] args) {
        String restaurantName = args[0];
        String reviewName = args[1];
        File database_restaurants = new File("./database_restaurants");
        /*
        System.out.println("Is this a directory? " + database_restaurants.isDirectory());

        File[] files = database_restaurants.listFiles();
        for (File fileName : files) {
            if (fileName.isDirectory())
            System.out.println(fileName.getName());

        }
         */
        /*
        ArrayList<Restaurant> arr = load(database_restaurants);
        for (Restaurant r : arr) {
                System.out.println(r.getName());
        }
        for (Restaurant r : arr) {
            System.out.println(r.getNumReviews());
        }
        System.out.println(countNumReviews(arr));
         */
        try {
            //System.out.println(readReview(database_restaurants, load(database_restaurants), "Chickfila", "Emma"));
            System.out.println(readReview(database_restaurants, load(database_restaurants), "Mcdonalds", "Allan"));
        } catch (ReviewNotFoundException a) {
            a.printStackTrace();
        } catch (NotARestaurantException b) {
            b.printStackTrace();
        }
    }
    public static ArrayList<Restaurant> load(File f) {
        ArrayList<Restaurant> arr = new ArrayList<>();
        loadHelper(f, arr);
        return arr;
    }
    public static ArrayList<Restaurant> loadHelper(File f, ArrayList<Restaurant> arr){
        if (f.isDirectory()
                && !(f.getName().length() >= 10
                && f.getName().substring(0,10).equals("restaurant"))) {
            File[] files = f.listFiles();
                ArrayList<File> arrFiles = new ArrayList<File>();
                for (File ff: files) {
                    if (ff.isDirectory()) {
                        arrFiles.add(ff);
                    }
            }
            for(File ff: arrFiles) {
                loadHelper(ff, arr);
            }
            //((f.getName().length() >= 10
            //                    && f.getName().substring(0,10).equals("restaurant")))
        } else if ((f.getName().length() >= 10
                && f.getName().substring(0,10).equals("restaurant"))){
            Restaurant r = new Restaurant(f.getName().substring(10),
                    f.list().length);
            arr.add(r);
            return arr;
        }
        return arr;
    }
    public static int countNumReviews(ArrayList<Restaurant> arr) {
        int count = 0;
        for (Restaurant r : arr) {
            count += r.getNumReviews();
        }
        return count;
    }
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
                    && f.getName().substring(10).equals(restaurantName))){
                File[] files = f.listFiles();
                ArrayList<File> arrFiles = new ArrayList<File>();
                for (File ff: files) {
                    if (ff.isDirectory()) {
                        arrFiles.add(ff);
                    }
                }
                for(File ff: arrFiles) {
                    return readReview(ff, arr, restaurantName, reviewName);
                }
            } else if (f.getName().length() >= 10
                    && f.getName().substring(10).equals(restaurantName)){
                boolean reviewExists = false;
                for (File ff : f.listFiles()) {
                    String s = ff.getName().substring(6);
                    if (s.substring(0,s.length() - 4).equals(reviewName)) {
                        try {
                            reviewExists = true;
                            Scanner myScan = new Scanner(ff);
                            myScan.nextLine();
                            myScan.nextLine();
                            myScan.next();
                            return myScan.nextDouble();
                        } catch (FileNotFoundException fnfe) { return 0.0;}
                    }
                }
                if(!reviewExists) {
                    throw new ReviewNotFoundException(reviewName);
                }
            }
        }
        return 0.0;
    }
}