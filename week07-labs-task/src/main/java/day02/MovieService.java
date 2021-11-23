package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        List<String> fileContent = new ArrayList<>();
        fileContent = getFileContent(path, fileContent);
        for (String row : fileContent) {
            String[] values = row.split(";");
            int year = 0;
            Movie movie = getMovie(values, year);
            this.movies.add(movie);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    private Movie getMovie(String[] values, int year) {
        try {
            year = Integer.parseInt(values[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid year!");
            nfe.printStackTrace();
        }
        return new Movie(values[0], year, values[2]);
    }

    private List<String> getFileContent(Path path, List<String> fileContent) {
        try {
            fileContent = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("No such file!", ioe);
        }
        return fileContent;
    }
}
