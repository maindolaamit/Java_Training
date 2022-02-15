package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamsDemo {

    /**
     * Read file and load data into a list
     *
     * @return List of books
     */
    static List<Book> loadBooksFromFile() {
        Path filePath = Paths.get("src/main/resources/streams_data_book.csv");
        List<Book> books = new ArrayList<>();
        try (Stream<String> stream = Files.lines(filePath).skip(1)) {
            stream.forEach(line -> {
                String[] tokens = line.split(";");
                Book book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[4]), tokens[3], tokens[0]);
                books.add(book);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total books in the list: " + books.size());
        return books;
    }

    public static void main(String[] args) {
        // Create a stream of strings ; stream = forEach(Consumer<T> consumer)
        Stream<String> stream = Stream.of("a", "b", "c");
        // Print the stream
        stream.forEach(System.out::println);
        // Create a stream of integers
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        // Print the stream
        stream2.forEach(System.out::println);
//        beforeStreams();
//        afterStreams();
//        reducerOperation();
        collectionOperation();
    }

    /**
     * Before streams
     * Group all the books based on category. You will create a map of category and list of books
     * HashMap<String, List<Book>>
     */
    static void beforeStreams() {
        System.out.println("========== Before stream ==========\n");
        List<Book> books = loadBooksFromFile();
        Map<String, List<Book>> booksByCategory = new HashMap<>();
        for (Book book : books) {
            String category = book.getCategory();
            // Check if category is not null or blank
            if (category != null && !category.isBlank()) {
                // Get the list from map if present else an empty ArrayList
                List<Book> bookList = booksByCategory.getOrDefault(category, new ArrayList<Book>());
                // Add the new book to the list
                bookList.add(book);
                // Update the map with new list of books
                booksByCategory.put(category, bookList);
            }
        }
        System.out.println(booksByCategory);
    }

    /**
     * After streams
     * Group all the books based on category. You will create a map of category and list of books
     * HashMap<String, List<Book>>
     */
    static void afterStreams() {
        System.out.println("========== After stream ==========\n");
        List<Book> books = loadBooksFromFile();
//        Map<String, List<Book>> collect = books.stream().collect(Collectors.groupingBy(b -> b.getCategory()));
//        System.out.println("booksByCategory = " + collect);

        List<Book> economics = books.stream().filter(b -> b.getCategory().equalsIgnoreCase("economics"))
                .collect(Collectors.toList());
        System.out.println(economics);

        // Take list of title limited to 5 elements
        List<String> booksTitle = books.stream().limit(5).map(Book::getTitle).collect(Collectors.toList());
        System.out.println("booksTitle = " + booksTitle);
    }

    private static void reducerOperation() {
        /**
         * Reducer is a function that takes two arguments and returns a single value.
         * The first argument is the accumulator and the second argument is the current value.
         * The accumulator is the result of the previous reduction and the current value is the next element in the stream.
         * It uses immutable reduction and can be used as the initial value for the accumulator.
         * reduce() takes supplier, accumulator and combiner(if type is different from input) as arguments.
         */
        List<Book> books = loadBooksFromFile();
        String reduce = books.stream().map(Book::getIsbn).limit(5)
                .reduce(""// Supplier<A>
                        , (a, b) -> a + b + ", " // accumulator BiConsumer<A, B>
                );
        System.out.println("reduce = " + reduce.substring(0, reduce.length() - 1));

        // Another reducer method with different datatype with combiner
        StringBuilder reduce2 = books.stream().map(Book::getIsbn).limit(2)
                .reduce(new StringBuilder()
                        , (a, b) -> a.append(b).append("-")
                        , (a, b) -> a.append(b) // BinaryOperator<A>
                        // required only in parallel stream but developer kept it like this instead of
                        // two versions to keep stream API agnostic of the underlying design
                );
        System.out.println("reduce2 = " + reduce2);

        // Another reducer method with different datatype without combiner
        StringBuilder reduce3 = books.stream().map(b -> new StringBuilder(b.getIsbn())).limit(2)
                .reduce(new StringBuilder(), (a, b) -> a.append(b).append(","));
        System.out.println("reduce3 = " + reduce3);

        // TODO : try above with parallel stream and see results
    }

    private static void collectionOperation() {
        /**
         * Collectors is a factory class that provides static methods for creating collectors.
         * Collectors are used to transform a stream into another form of type container.
         * Collectors can be used to perform common operations on a stream.
         * It is uses mutable reduction and can be used as the initial value for the accumulator.
         * Collector optionally take finisher to transform the container object
         */
        List<Book> books = loadBooksFromFile();
        // collect method
//        List<String> isbnList = books.stream().map(Book::getIsbn).collect(",", (a,b)->a+b);
        String collect = books.stream().map(Book::getIsbn)
                .collect(StringBuilder::new
                        , (a, b) -> a.append(b).append(",")
                        , (a, b) -> a.append(b)
                ).toString();
        System.out.println("collect = " + collect);

        String collect2 = books.stream().map(Book::getIsbn).collect(Collectors.joining(","));
        System.out.println("collect2 = " + collect2);

        // Collect to List using Collectors helper class
        List<String> isbnList = books.stream().map(Book::getIsbn).collect(Collectors.toList());
        System.out.println("collect = " + isbnList);

        // Another collector method
        ArrayList<String> collect1 = books.stream().map(Book::getIsbn).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collect1 = " + collect1);

        // Group books by Category
        Map<String, List<Book>> byCategory = books.stream().collect(Collectors.groupingBy(Book::getCategory));
        System.out.println("byCategory = " + byCategory);

        // count by Category
        Map<String, Long> byCategoryCount = books.stream()
                .collect(Collectors.groupingBy(Book::getCategory, Collectors.counting()));

        // Sum of rating
        Long byCategorySum =
                books.stream().filter(b -> b.getIsbn() != null && !b.getIsbn().isBlank()).map(Book::getIsbn)
                        .collect(Collectors.counting());
    }

    static void streamOperationsExercise() {
        // how many books having rating > 7
        // how many books having ISBN as null
        // At most 5 books with rating > 7
        // Is there at least one highly rated book >=4.8
        // How many books in biography with rating above 7
        // Book having the lowest rating
        // Book having the highest rating
        // Average rating of all books
        // Average rating of all books by Category
    }
}
