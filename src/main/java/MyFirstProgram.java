import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    private static void passByValueDemo() {
        Student st = new Student("chanda", "123", "test@gmai.com", 1);
        updateStudent(st);
        System.out.println(String.format("Inside method - name : %s , rollNumber : %d "
                , st.getName(), st.getRollNumber()));

        //        isSubstring("Amit Reddy", "x");
        int a = 10;
        System.out.println("a = " + a);
        updatePrimitive(a);
        System.out.println("a = " + a);
    }

    public static void testEquals() {
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
    }

    /**
     * Method to receive multiple integers and return their sum
     *
     * @param a Array of ints
     * @return Sum of the Numbers
     */
    static int sumNumbers(int[] a) {
        int sum = 0;
        // Loop over each element in the array and add to sum
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    static int sumNumbers2(int... a) {
        // by default, it will check if a has any value or not ...
        // an empty list will created and assigned to a on the fly
        int sum = 0;
//        if (a == null) {
//            return sum;
//        }
        // Loop over each element in the array and add to sum
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    static void vargsDemo() {
//        int[] b = {1, 2, 3};
//        int sum = sumNumbers({1, 2, 3}); // will it work
        int[] a = new int[]{1, 2, 3, 4};
//        int sum = sumNumbers(null); // raise exception
        int sum = sumNumbers2();
        System.out.println("sum = " + sum);
        sum = sumNumbers2(a);
        System.out.println("sum = " + sum);
    }

    static void tenraryAndForeach() {
        int a = 100;
        boolean isOdd = true;
        if (a % 2 == 0) {
            isOdd = false;
        }
        // ternary operator
        boolean isEven = a % 2 == 0 ? true : false;

        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < ints.length; i++) {
            int value = ints[i];
            System.out.println("index : " + i + ", value = " + value);
        }
        System.out.println("------");
        int i = 0;
        for (int value : ints) {
            System.out.println("index : " + i++ + ", value = " + value);
//            System.out.println("value = " + value);
        }
    }

    static void testLegacyDateAPI() {
        Date currentDate = new Date();
        System.out.println("currentDate: " + currentDate);
        Calendar expiryDate = new GregorianCalendar(2017, 05, 30);
        System.out.println("expiryDate : " + expiryDate);
        System.out.println("expiryDate Time : " + expiryDate.getTime());
        expiryDate.add(Calendar.MONTH, 8);
        System.out.println("expiryDate Time : " + expiryDate.getTime());
    }

    static void testDateTimeAPI() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDate expiryDate = LocalDate.of(2021, 03, 21);
        System.out.println("expiryDate = " + expiryDate);
        expiryDate = expiryDate.plusMonths(1);
        System.out.println("After adding month - expiryDate = " + expiryDate);
        System.out.println("expiryDate.getYear() = " + expiryDate.getYear());
        System.out.println("expiryDate.getMonth() = " + expiryDate.getMonth());
        System.out.println("expiryDate.getDayOfMonth() = " + expiryDate.getDayOfMonth());
        System.out.println("expiryDate.lengthOfMonth() = " + expiryDate.lengthOfMonth());

        // Parsing a date
        String date = "2021/Mar/21 14:05:55";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println("parsed date = " + parse);
    }

    static void finalDemo() {
        final Student finalStudent = new Student("shilpa", "1", "test@mail.com", 1);
        System.out.println("finalStudent = " + finalStudent);
        Student student = new Student("Vishal", "2", "test@mail.com", 2);
        Student student1 = new Student("Deepak", "3", "test@mail.com", 3);
        System.out.println("student = " + student);
        student = student1;
        System.out.println("student = " + student);
        System.out.println("Changing roll number for final student");
        // Final prevent re-assigning but the Object is not Immutable
        finalStudent.setRollNumber(5);
        System.out.println("finalStudent = " + finalStudent);
    }

    public static void main(String[] args) {
        /**
         * Employee class having 3 fields {id, name, email}
         * 4 Sources - XML, JSON, CSV, Excel
         * Main class - load data from any of the source and into a target.
         * =========== Clauses ============
         * Parse the data and convert to list of Students
         * Before loading to DB we will have data converted a List of Students
         * Loader class will receive List of Students as input to load data.
         *
         * ============
         * AbstractSource - which will have some common functionalities
         *
         */
        finalDemo();
    }

}
