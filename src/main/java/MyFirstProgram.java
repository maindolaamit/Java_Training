
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

    /**
     * This method checks if the given checkString is a substring in MainString.
     *
     * @param mainString  Main String
     * @param checkString string to be checked
     * @return Return true if substring else false
     */
    public static boolean isSubstring(String mainString, String checkString) {
        // Convert to char array
        char[] main = mainString.toCharArray(), subStr = checkString.toCharArray();
        int lenMainString = main.length, lenCheckString = subStr.length;

        // check the length of main string, if lesser than return false.
        // mainString -> "am", checkString -> "ami"
        if (lenMainString < lenCheckString) {
            return false;
        }

        // check the first character of check string in main string
        for (int i = 0; i < lenMainString; i++) {
            if (main[i] == subStr[0]) {
                for (int j = 0; j < lenCheckString - 1; j++) {
                    // check for each character in substr against the main string
                }
            }
        }
        System.out.println("lenMainString = " + lenMainString);
        return true;
    }

    static void stringsConcept() {
        String a = "test";  // 12312312
        String b = "test";
//        String b = a.toUpperCase().toLowerCase();
        b = b.toUpperCase();

        boolean result = a == b;
        System.out.println(result);

    }

    static void update_primitive(int a) {
        a = a + 10;
        System.out.println("inside method a = " + a);
    }

    public static void main(String[] args) {

//        Student st = new Student("chanda", "123", "test@gmai.com", 1);
//        System.out.println(st.toString());
//        stringsConcept();

//        isSubstring("Amit Reddy", "x");
        int a = 10;
        System.out.println("a = " + a);
        update_primitive(a);
        System.out.println("a = " + a);
    }
}
