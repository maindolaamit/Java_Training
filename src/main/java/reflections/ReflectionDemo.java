package reflections;

import io.Book;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Using Java Reflection you can inspect and extract the information about a class such as
 * various constructors it has, methods, fields etc. We can also instantiate objects at runtime.
 * Used extensively in Debuggers, Unit Testing Frameworks and Mocking Frameworks
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class aClass = SampleClass.class;
        System.out.println("Class Name = " + aClass.getName());
        System.out.println("Package Name = " + aClass.getPackageName());
        // Get the constructors of class
        Constructor[] constructors = aClass.getConstructors();
        StringBuilder str = new StringBuilder("{");
        Arrays.stream(constructors).forEach(c -> {
            str.append(c.getName()).append("(");
            str.append(Arrays.stream(c.getParameterTypes())
                            .map(t -> t.getName())
                            .collect(Collectors.joining(",")))
                    .append("), ");
        });
        str.append("}");
        System.out.println(str);

        // View all declared methods
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            method.getParameters();
            System.out.println(String.format("Method %d - %s %s(%s)", i, Modifier.toString(method.getModifiers()),
                    method.getName(), Arrays.toString(method.getParameters())));
        }

        // Invoke a private method
        SampleClass sampleClass = new SampleClass("A", 65);
        String privateMethod = "computeValue";
        try {
            System.out.println("Invoking private method");
            Method method = aClass.getDeclaredMethod(privateMethod);
            method.setAccessible(true);
            Object result = method.invoke(sampleClass);
            System.out.println("result = " + result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
