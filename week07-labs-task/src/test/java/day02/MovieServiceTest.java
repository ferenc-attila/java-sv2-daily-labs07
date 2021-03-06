package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieServiceTest {

    @Test
    void createValidPathTest() {
        Path path = Paths.get("src/test/resources/movies.csv");
        MovieService movieService = new MovieService(path);

        assertEquals(5, movieService.getMovies().size());
        assertEquals("Star Wars", movieService.getMovies().get(2).getTitle());
        assertEquals("Peter Jackson", movieService.getMovies().get(3).getDirector());
        assertEquals(1993, movieService.getMovies().get(0).getYear());
    }

    @Test
    void createInvalidPathTest() {
        Path path = Paths.get("src/test/resources/movie_.csv");

        IllegalStateException iae = assertThrows(IllegalStateException.class,
                () -> new MovieService(path));
        assertEquals("No such file!", iae.getMessage());
        assertEquals(NoSuchFileException.class, iae.getCause().getClass());
    }
}