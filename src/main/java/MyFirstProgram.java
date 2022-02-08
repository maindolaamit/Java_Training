
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

    /**
     * Java always pass by value, in case of primitive the value is stored in the stack
     *
     * @param a An Object
     */
    static void updatePrimitive(int a) {
        a = a + 10;
        System.out.println("inside method a = " + a);
    }

    /**
     * Java always pass by value, in case of Objects the value stored in stack is actual memory location of the object.
     * So the value passed to the method is actually the address of the Object.
     *
     * @param s
     */
    static void updateStudent(Student s) {
        s.setRollNumber(s.getRollNumber() + 100);
        System.out.println(String.format("Inside method - name : %s , rollNumber : %d "
                , s.getName(), s.getRollNumber()));
    }

    public static void main(String[] args) {
        Student st = new Student("chanda", "123", "test@gmai.com", 1);
        System.out.println("st = " + st.toString());

        Student st1 = new Student("chanda", "123", "test@gmai.com", 1);
        System.out.println("st1 = " + st1.toString());

//        if (st1 == st) {
        if (st1.equals(st)) {
            System.out.println("Both students are same");
        } else {
            System.out.println("Not same.");
        }
/*
        updateStudent(st);
        System.out.println(String.format("Inside method - name : %s , rollNumber : %d "
                , st.getName(), st.getRollNumber()));

        //        isSubstring("Amit Reddy", "x");
        int a = 10;
        System.out.println("a = " + a);
        updatePrimitive(a);
        System.out.println("a = " + a);
*/
    }
}
