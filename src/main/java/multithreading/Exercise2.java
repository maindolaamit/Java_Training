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
public class Exercise2 {
    static int sampleSize = 0;
    static int quantitySold = 0;

    public static void main(String[] args) {
        String[] files = {"/data/1.csv", "/data/2.csv", "/data/3.csv"};
        // Use multiple threads to increment the values in the files.
        for (String filePath : files) {
            Path path = null;
            try {
                path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(filePath).toURI());
                // TODO
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } finally {
                // TODO
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Global Superstore data: ");
        String name = scan.nextLine();
        System.out.println("\nThank you " + name + ".\n");
        scan.close();

        // Print the results.
        System.out.println("sampleSize = " + sampleSize);
        System.out.println("quantitySold = " + quantitySold);
    }

    /**
     * TODO
     * Task : increment the sampleSize and quantitySold.
     *
     * @param file Inside the function:
     *             1. Runs through every line in the file.
     *             2. Maps each element in the stream to a quantity value.
     *             3. Increments sampleSize and quantitySold.
     */
    private static void increment(Path file) {

    }
}
