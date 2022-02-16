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

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public boolean contains(Movie movie) {
        for (Movie movie1 : this.movies) {
            if (movie1.equals(movie)) {return true;}
        }
        return false;
    }

    // Sell the movie
    public boolean sellMovie(Movie movie) {
        if (this.contains(movie) && movie.isAvailable()) {
            this.movies.remove(movie);
            System.out.println("Movie sold.");
            return true;
        }
        System.out.println("Movie not found.");
        throw new IllegalStateException("Movie not found.");
    }

    public void rentMovie(Movie movie) {
        if (this.contains(movie)) {
            movie.setAvailable(false);
        }
    }

    // Return the rentred movie
    public void returnMovie(Movie movie) {
        if (this.contains(movie)) {
            movie.setAvailable(true);
        }
    }
}
