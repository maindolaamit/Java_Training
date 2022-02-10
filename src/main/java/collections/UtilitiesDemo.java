package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilitiesDemo {
    public static void main(String[] args) {
        //
        List<int[]> asList = Arrays.asList(new int[]{1, 2, 3});
        List<int[]> ints = List.of(new int[]{1, 2, 3});
        List<Integer> integerList = List.of(1, 2, 3);
        //
        Integer max = Collections.max(integerList);
        System.out.println("max = " + max);
    }
}
