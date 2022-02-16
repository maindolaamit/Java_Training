package ut.moviestore.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Cases
 * ----------------------------------------
 * - adding a movie
 * - Test if the store contains the movie after it's added.
 * - selling a movie
 * - Test if the movie gets removed after being sold.
 * - Test for an IllegalStateException for selling a rented movie.
 * - renting a movie
 * - Test if the movie becomes rented.
 * - returning a movie
 * - Test if the movie is available again.
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StoreTest {
    Store store;

    @BeforeEach
        // Initialize the store before each test
    void setUp() {
        store = new Store();
        Movie movie = new Movie("Pushpa", "Blue-Ray", 7.7);
        Movie movie1 = new Movie("Shashwank Redemption", "Blue-Ray", 9.7);
        Movie movie2 = new Movie("Visharoopam", "DVD", 8.7);
        store.addMovie(movie);
        store.addMovie(movie1);
        store.addMovie(movie2);
    }

    @Test
    @DisplayName("Check if movie is present after adding it")
    void addItem() {
        // Test if the cart contains the item after it's added.
        Movie movie = new Movie("Why I killed Gandhi", "Blue-Ray", 7.7);
        store.addMovie(movie);
        assertTrue(store.contains(movie));
    }

    @Test
    void movie_present_after_sold() {
        // Test if the cart contains the movie after it's sold.
        Movie movie = new Movie("Why I killed Gandhi", "Blue-Ray", 7.7);
        assertThrows(IllegalStateException.class, () -> store.sellMovie(movie));

        Movie movie1 = new Movie("Shashwank Redemption", "Blue-Ray", 9.7);
        assertTrue(store.sellMovie(movie1));
    }

    @Test
    void sell_a_rented_movie() {
        Movie movie = store.getMovie(0);
        store.rentMovie(movie);
        assertThrows(IllegalStateException.class, () -> store.sellMovie(movie));
    }

    @Test
    void return_rented_movie() {
        Movie movie = store.getMovie(0);
        store.rentMovie(movie);
        assertFalse(movie.isAvailable());
        store.returnMovie(movie);
        assertTrue(movie.isAvailable());
    }
}