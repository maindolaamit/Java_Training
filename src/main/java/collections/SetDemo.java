package collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        // In a set we have hash value as key and given element as value
        Set<String> set1 = new HashSet<>();
        set1.add("d");
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("c");

        System.out.println("set1 = " + set1);

        // Set of Book objects
        Book book = new Book("Effective Java", "Java", "Vishal");
        Book book1 = new Book("OOPS in Java", "Java", "Tushar");
        Book book2 = new Book("DS in Java", "Java", "Dadlani");
        Book book3 = new Book("DS in Java", "Java", "Dadlani");
        List books = List.of(book, book1, book2, book3);
        // when adding an element to the set, hashcode of object will be computed and taken as key
        Set<Book> set2 = new HashSet<>();
        set2.add(book);
        set2.add(book1);
        set2.add(book2);
        set2.add(book3);
        System.out.println("books = " + books);
        System.out.println("set2 = " + set2);
        System.out.println("set2.contains(book1) = " + set2.contains(book1));
        book1.setAuthor("Radha");
        System.out.println("set2 = " + set2);
        System.out.println("set2.contains(book1) = " + set2.contains(book1));
    }
}
