package lambda;

import javax.print.attribute.standard.PrinterStateReason;
import javax.xml.crypto.dsig.Transform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SimpleNumberHelper {
    public static int sumTwoNumber(int a, int b) {
        System.out.println("Calculating the sum of " + a + " and " + b);
        return a + b;
    }

    public static int diffTwoNumber(int a, int b) {
        System.out.println("Calculating the difference of " + a + " and " + b);
        return a - b;
    }

    public static int mulTwoNumber(int a, int b) {
        System.out.println("Calculating the product of " + a + " and " + b);
        return a * b;
    }

    public static int divTwoNumber(int a, int b) {
        System.out.println("Calculating the division of " + a + " and " + b);
        return a % b;
    }

    // Using Predicate functional interface
    public static boolean filter(int a, Predicate<Integer> predicate) {
        return predicate.test(a);
    }

    /**
     * A filter method which accepts an array of integer and a filter condition to apply
     *
     * @param numbers   an array of integer
     * @param predicate a filter condition
     * @return a list of filtered numbers
     */
    public static Integer[] filter(int[] numbers, Predicate<Integer> predicate) {
        List<Integer> list = new ArrayList<>();
        // Filter the given numbers using the predicate
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                list.add(number);
            }
        }
        //    Create an array of the filtered numbers
        Integer[] filteredArray = new Integer[list.size()];
        //    save the numbers in the array
        return list.toArray(filteredArray);
    }

    /**
     * A filter method which accepts an array of integer and a filter condition to apply
     *
     * @param numbers       an array of integer
     * @param operationType The type of operation to apply
     * @return a list of filtered numbers
     */
    public static Integer[] filter(int[] numbers, String operationType) {
        List<Integer> list = new ArrayList<>();
        if (operationType.equalsIgnoreCase("even")) {
            filter(numbers, (number) -> number % 2 == 0);
        } else if (operationType.equalsIgnoreCase("odd")) {
            filter(numbers, (number) -> number % 2 == 1);
        } else {
            throw new IllegalArgumentException("Invalid operation type");
        }
        //    Create an array of the filtered numbers
        Integer[] filteredArray = new Integer[list.size()];
        //    save the numbers in the array
        return list.toArray(filteredArray);
    }

    public static int transformInteger(int a, Function<Integer, Integer> transform) {
        return transform.apply(a);
    }
}
