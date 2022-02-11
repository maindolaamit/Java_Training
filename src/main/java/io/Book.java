package io;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String name;
    private String category;
    private String author;
    Integer price; // added a new field

    // Added to handle incompatibility issue
    private static final long serialVersionUID = 905310033078904292L;

    public Book(String name, String title, String author) {
        this.name = name;
        this.category = title;
        this.author = author;
        this.price = 100; // handle default value
    }

    // constructor chaining
    public Book(String name, String category, String author, Integer price) {
        this(name, category, author);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public boolean isEqualsTo(Book book) {
        if (this.name.equals(book.getName()) && this.author.equals(book.getAuthor())
                && this.category.equals(book.getCategory())) {
            return true;
        }
        return false;
    }
}
