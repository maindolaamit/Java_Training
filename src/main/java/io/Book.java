package io;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String name, category, author;

    public Book(String name, String title, String author) {
        this.name = name;
        this.category = title;
        this.author = author;
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
                '}';
    }

    public boolean isEqualsTo(Book book) {
        if (this.name.equals(book.getName()) && this.author.equals(book.getAuthor())
                && this.author.equals(book.getAuthor())) {
            return true;
        }
        return false;
    }
}
