package ut.moviestore.models;

import java.util.ArrayList;

/**
 * The store sells movies and lets the user rent/return them.
 * The store starts by adding movies to its collection.
 * A movie is described by its name, format, and rating.
 */
public class Store {
    ArrayList<ut.moviestore.models.Movie> movies;

    public Store() {
        this.movies = new ArrayList<ut.moviestore.models.Movie>();
    }

    public ut.moviestore.models.Movie getMovie(int index) {
        return new ut.moviestore.models.Movie(this.movies.get(index));
    }

    public void setMovie(int index, ut.moviestore.models.Movie movie) {
        this.movies.set(index, new ut.moviestore.models.Movie(movie));
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
