package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Book> map = new HashMap<>();
        Book book = new Book("Effective Java", "Java", "Vishal");
        Book book1 = new Book("OOPS in Java", "Java", "Tushar");
        Book book2 = new Book("DS in Java", "Java", "Dadlani");
        Book book3 = new Book("DS in Java", "Java", "Dadlani");
        map.put("a", book);
        map.put("b", book);
        map.put("c", book);
        map.put("d", book);
        System.out.println("map = " + map);

        // clear the map
        HashMap<Book, String> map1 = new HashMap<>();
        map1.put(book, book.toString());
        map1.put(book1, book1.toString());
        map1.put(book2, book2.toString());
        System.out.println("map1.keySet().size() = " + map1.keySet().size());
        System.out.println("map1.containsKey(book2) = " + map1.containsKey(book2));
        System.out.println("map1 = " + map1);
        book2.setAuthor("Radha");
        System.out.println("map1.keySet().size() = " + map1.keySet().size());
        // key does exist in the hashtable but new hashvalue of the key is not present in the table
        // thus giving false
        System.out.println("map1.containsKey(book2) = " + map1.containsKey(book2));
    }
}
