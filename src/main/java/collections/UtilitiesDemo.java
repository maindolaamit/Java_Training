package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilitiesDemo {
    public static void main(String[] args) {
        //
        List<Integer> asList = Arrays.asList(1, 2, 3); // returns mutable list, allows null elements, can have null
        List<Integer> listOf = List.of(1, 2, 3); // returns immutable list, null not allowed
                
        // both list does not allow structural immutability
        asList.set(1, 10); // operation not allowed
        System.out.println("asList = " + asList);

        //
        listOf.set(1, 10); // operation allowed
        System.out.println("listOf = " + listOf);
        //
        Integer max = Collections.max(listOf);
        System.out.println("max = " + max);
    }
}
