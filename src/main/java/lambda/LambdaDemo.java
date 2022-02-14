package lambda;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Lambdas often called anonymous functions which can represented in a single statement
 * FunctionalInterface - are the Interface which has single method to implement
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // MyFunctionalInterface --> MyFunctionalInterfaceImpl
        // Traditional convention by creating a concrete class
        MyFunctionalInterfaceImpl intfImpl = new MyFunctionalInterfaceImpl();
        intfImpl.implementMe();

        // Traditional convention without creating a concrete class
        MyFunctionalInterface intf = new MyFunctionalInterface() {
            @Override
            public void implementMe() {
                System.out.println("hello, i am not a concrete class");
            }
        };
        intf.implementMe();
        /*
        () -> {}
        Above is the lambda syntax which may have one or more parameters
        we can also ommit {} if we have only one statement
        */

        MyFunctionalInterface intf1 = () -> System.out.println("Calling from Lambda method");
        MyFunctionalInterface intf2 = () -> {
            System.out.println("Another Lambda method");
            System.out.println("But multiple statements this time.");
        };

        // Another Interface to return sum of two number
        // we can ommit return if only single statement
        SimpleSumIntf sum = (int a, int b) -> a + b;
        System.out.println(sum.sumTwoNumber(2, 3));
        // We can use any existing static method of a class with has the same signature
        SimpleSumIntf sum1 = Integer::sum;
        System.out.println(sum1.sumTwoNumber(4, 5));
        // Using our own static method
        SimpleSumIntf sum3 = SimpleNumberHelper::sumTwoNumber;
        System.out.println(sum3.sumTwoNumber(10, 20));

        // multiple usages
        // Assign the abstract method in SimpleNumberOprIntf to SimpleNumberHelper method
        SimpleNumberOprIntf diff = SimpleNumberHelper::diffTwoNumber;
        System.out.println(diff.numberOperation(10, 20));

        diff = SimpleNumberHelper::mulTwoNumber;
        System.out.println(diff.numberOperation(4, 5));

        javaInbuitFI();
    }

    /**
     * Java has a lot of inbuilt functional interface
     * It is better to use them rather than creation a new for your own
     */
    private static void javaInbuitFI() {
        System.out.println("========== Java Inbuilt Functional Interface ==========\n");
        // Functional interface - predicate
        Integer number = 10;
        boolean isEven = SimpleNumberHelper.filter(number, a -> a % 2 == 0);
        System.out.println(number + " - is even ? " + isEven);
        boolean isOdd = SimpleNumberHelper.filter(number, a -> a % 2 == 1);
        System.out.println(number + " - is odd ? " + isOdd);
        // filter the number array to get only even numbers
        Integer[] evenNumber = SimpleNumberHelper.filter(new int[]{1, 23, 4, 5, 6, 7, 20}, a -> a % 2 == 0);
        System.out.println("List of even numbers : " + Arrays.toString(evenNumber));

        Integer[] oddNumber = SimpleNumberHelper.filter(new int[]{1, 23, 4, 5, 6, 7, 20}, "odd");
        System.out.println("List of odd numbers : " + Arrays.toString(oddNumber));

        System.out.println("Using Function interface to perform operation");
        System.out.println(SimpleNumberHelper.transformInteger(number, n -> n * 5));
        System.out.println(SimpleNumberHelper.transformInteger(number, n -> n / 5));
        System.out.println(SimpleNumberHelper.transformInteger(number, n -> n + 5));
        System.out.println(SimpleNumberHelper.transformInteger(number, n -> n - 5));

        // Function interface - Function
        Function<Integer, Integer> square = n -> n * n;
        System.out.println(square.apply(number));
    }
}
