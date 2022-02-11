package lambda;

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
}
