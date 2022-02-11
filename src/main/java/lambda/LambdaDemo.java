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
    }
}
