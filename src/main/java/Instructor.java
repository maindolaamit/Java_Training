import java.util.Arrays;

public class Instructor {
    public long id;
    public String name;
    public String title;
    public String department;
    public Book[] books;

    public Instructor(long id, String name, String title, String department, Book[] books) {
        // your code
    }

    public Instructor(long id, String name, String title, String department) {
        this(id, name, title);
        this.department = department;
    }

    public Instructor(long id, String name, String title) {
        this(id, name);
        this.title = title;
    }

    public Instructor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }

    /**
     * todo : by students
     * This method should return the book title of the last element in the Books array.
     * Books array can have any number of elements
     *
     * @return Book title of the last book in array
     */
    public String getMostRecentBookTitle() {
        // your code
        return null;
    }

    /**
     * todo : by students
     * This method will update the Book instance at the specified index in the Books array with the specified book
     * title.
     * The method should also return the Book object which will have the old book for which title was updated.
     *
     * @param index Index in array to update.
     * @param title New title of the book to update.
     * @return Returns the old book object
     */
    public Book updateBook(int index, String title) {
        // your code
        return null;
    }

    /**
     * todo : by students
     * This method updates the Book instance at the specified index in the Books array with the given Book object.
     *
     * @param index Index in array to update.
     * @param book  New book object
     * @return Returns the old book object
     */
    public Book updateBook(int index, Book book) {
        // your code
        return null;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java for Beginners");
        Book book2 = new Book("Scala for Beginners");
        Book book3 = new Book("Effective Python");

//        Instructor instructor = new Instructor(101, "John", "Assistant Professor",
//                "Computer Science", new Book[]{book1, book2, book3});
        Instructor instructor = new Instructor(101, "John");
        System.out.println("instructor = " + instructor.toString());
//        System.out.println(instructor.getMostRecentBookTitle());
//        System.out.println("old book title: " + instructor.updateBook(1, "Effective C#").getTitle());

//        Book book4 = new Book("Introduction to Data Mining");
//        System.out.println("old book title: " + instructor.updateBook(1, book4).getTitle());
    }
}
