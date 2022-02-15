package multithreading;

import lambda.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyThread extends Thread {
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

    private Map<String, Long> getBooksByCategory(List<Book> books) {
        // count by Category
        Map<String, Long> byCategoryCount = books.stream()
                .collect(Collectors.groupingBy(Book::getCategory, Collectors.counting()));
        return byCategoryCount;
    }

    @Override
    public void run() {
        List<Book> books = loadBooksFromFile();
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));
            Map<String, Long> byCategoryCount = getBooksByCategory(books);
            System.out.println("Total books in the list: " + books.size());
            System.out.println("Total books by category: " + byCategoryCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
