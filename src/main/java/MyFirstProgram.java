
public class MyFirstProgram {

    public static void printMyName(String name) {
        System.out.println("Hello " + name + ", Welcome !!!");
    }

    static enum Fruits {
        KIWI, ORANGE, APPLE, GUAVA, BANANA
    }

    public static void whileLoop() {
        boolean condition = true;
        int i = 1;
        System.out.println("i = " + i);
        while (condition) {
            System.out.println("i = " + i);
            if (i++ < 3) {
                System.out.println("i = " + i);
                printMyName("chanda");
            }

            condition = i < 3;
        }
        System.out.println("i = " + i++);
        System.out.println("i = " + ++i);
    }

    // TODO : to implement by students
    public static boolean isSubstring(String mainString, String checkString) {

        return true;
    }

    static void stringsConcept() {
        String a = "test";  // 12312312
        // Todo : check with Vishwa : why different objects are created for a and b
        String b = "test";
//        String b = a.toUpperCase().toLowerCase();
        b = b.toUpperCase();

        boolean result = a == b;
        System.out.println(result);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("My First Java Program");
        String[] fruits = {"GUAVA", "APPLE", "BANANA"};

//        Student st = new Student("chanda", "123", "test@gmai.com", 1);
//        System.out.println(st.toString());
        stringsConcept();
    }

}
