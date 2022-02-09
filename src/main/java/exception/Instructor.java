package exception;

import java.util.Arrays;

public class Instructor {
    public long id;
    public String name;
    public String title;
    public String department;
    public Book[] books;

    public Instructor(long id, String name, String title, String department, Book[] books) {
        this(id, name, title, department);
        this.books = books;
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
        return "exception.Instructor{" +
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
     * @return exception.Book title of the last book in array
     */
    public String getMostRecentBookTitle() {
        if (this.books == null || this.books.length == 0) {
            return "No books present.";
        }
        return this.books[this.books.length - 1].title;
    }

    /**
     * todo : by students
     * This method will update the exception.Book instance at the specified index in the Books array with the specified book
     * title.
     * The method should also return the exception.Book object which will have the old book for which title was updated.
     *
     * @param index Index in array to update.
     * @param title New title of the book to update.
     * @return Returns the old book object
     */
    public Book updateBook(int index, String title) {
        Book oldBook = this.books[index];
        this.books[index] = new Book(title);
        return oldBook;
    }

    /**
     * todo : by students
     * This method updates the exception.Book instance at the specified index in the Books array with the given exception.Book object.
     *
     * @param index Index in array to update.
     * @param book  New book object
     * @return Returns the old book object
     */
    public Book updateBook(int index, Book book) {
        Book oldBook = this.books[index];
        this.books[index] = book;
        return oldBook;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java for Beginners");
        Book book2 = new Book("Scala for Beginners");
        Book book3 = new Book("Effective Python");

//        Instructor instructor = new Instructor(101, "John", "Assistant Professor",
//                "Computer Science", new Book[]{book1, book2, book3});
//        exception.Instructor instructor = new exception.Instructor(101, "John");
//        System.out.println("instructor = " + instructor.toString());
//        System.out.println(instructor.getMostRecentBookTitle());
//        System.out.println("old book title: " + instructor.updateBook(1, "Effective C#").getTitle());
//
//        Book book4 = new Book("Introduction to Data Mining");
//        System.out.println("old book title: " + instructor.updateBook(1, book4).getTitle());
        // Scenario - Passing null to the Books
        Instructor instructor = new Instructor(101, "John", "Assistant Professor",
                "Computer Science", null);
        System.out.println("instructor = " + instructor.toString());
        System.out.println(instructor.getMostRecentBookTitle());

        // Scenario - Passing empty Array to the Books
        Instructor instructor1 = new Instructor(102, "Astha", "Professor",
                "Computer Science", new Book[]{});
        System.out.println("instructor1 = " + instructor1.toString());
        System.out.println(instructor1.getMostRecentBookTitle());
    }
}