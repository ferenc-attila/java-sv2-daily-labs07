package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {

    public Courier createCourierByFile(Path path) {
        Courier courier = new Courier();
        try {
            List<String> contentOfFile = Files.readAllLines(path);
            for (String row : contentOfFile) {
                String[] values = row.split(" ");
                courier.addRide(new Ride(
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!", ioe);
        }
        return courier;
    }
}
