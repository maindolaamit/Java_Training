package lambda;

/**
 * A concrete class implementing MyFunctionalInterface
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    /**
     * Override the method and give some implementation
     */
    @Override
    public void implementMe() {
        System.out.println("Implemented the interface in concrete class");
    }
}
