package lambda;

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
        System.out.println(sum.sumTwoNumber(2,3));
        // We can use any existing static method of a class with has the same signature
        SimpleSumIntf sum1 = Integer::sum;
        System.out.println(sum1.sumTwoNumber(4, 5));
        // Using our own static method
        SimpleSumIntf sum3 = SimpleNumberHelper::sumTwoNumber;
        System.out.println(sum3.sumTwoNumber(10, 20));

        // multiple usages
        SimpleNumberOprIntf diff = SimpleNumberHelper::diffTwoNumber;
        System.out.println(diff.numberOperation(10, 20));

        diff = SimpleNumberHelper::mulTwoNumber;
        System.out.println(diff.numberOperation(4, 5));
    }
}
