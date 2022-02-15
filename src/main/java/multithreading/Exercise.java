package multithreading;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * You will be building an Application for a Superstore which requires multiple threads.
 * Inside the data directory, a CSV file stores ~1,000,000 records.
 * The main() method already contains boilerplate code that locates the Path of the csv file.
 * The file has below contents:
 * Category, Price of item in category, Quantity of item sold
 * Implement the MultiThreading to calculate the average price of each category and total average.
 */
public class Exercise {
    public static void main(String[] args) {
        Path path = null;
        try {
            path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("data/sales.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println("No. of processors: " + Runtime.getRuntime().availableProcessors());
        // Create a ThreadPoolExecutor with 4 threads or as per available processors
        // Calculate the average price of each category
        Double techSales = average(path, "Technology");
        Double furnitureSales = average(path, "Furniture");
        Double officeSuppliesSales = average(path, "Office Supplies");
        // Calculate the average price of all categories
        Double totalSales = totalAverage(path);

        // Take input from the user
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Superstore dataset: ");
        String name = scan.nextLine();
        System.out.println("Access Denied. We apologize for the inconvenience. Have a good day " + name + ".");
        scan.close();

        // Wait for the Threads to die and Print the results
        // Instead of using Thread.join(), use the Future.get() method
        System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
        System.out.println("Average Furniture Sales: " + furnitureSales);
        System.out.println("Average Technology Sales: " + techSales);
        System.out.println("Average Office Supplies Sales: " + officeSuppliesSales);
        System.out.println("Total Average: " + totalSales);
    }

    /**
     * Function name: totalAverage
     *
     * @param path
     * @return Double
     * <p>
     * Inside the function:
     * 1. Runs through every line from the CSV file as a stream.
     * 2. Maps every element in the stream to an array of three values.
     * 3. Maps every element in the stream to a double (price * quantity)
     * 4. Applies the terminal operation average
     * 5. Returns the average as double.
     * In the event of an exception, print its message and return 0.
     * TODO : Implement the totalAverage function
     */
    public static Double totalAverage(Path path) {
        return null;
    }

    /**
     * Function name: average
     *
     * @param path     (Path)
     * @param category (String)
     * @return Double
     * <p>
     * Inside the function:
     * 1. Runs through every line from the CSV file as a stream.
     * 2. Maps every element in the stream to an array of three values.
     * 3. Filters every value by the @param category
     * 4. Maps every element in the stream to a double (price * quantity).
     * 5. Applies the terminal operation average.
     * 6. Returns the average as double.
     * In the event of an exception, print its message and return 0.
     * TODO: Implement the average function
     */
    public static Double average(Path path, String category) {
        return null;
    }
}
