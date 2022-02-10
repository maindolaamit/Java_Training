package collections;

import java.io.OutputStream;
import java.util.Objects;

public class Book {
    String name, category, author;

    public Book(String name, String title, String author) {
        this.name = name;
        this.category = title;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
//        return "Book{" +
//                "name='" + name + '\'' +
//                ", category='" + category + '\'' +
//                ", author='" + author + '\'' +
//                '}';
        return String.format("(%s-%s)", this.hashCode(), name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getName(), book.getName()) && Objects.equals(getCategory(), book.getCategory()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategory(), getAuthor());
    }
}
