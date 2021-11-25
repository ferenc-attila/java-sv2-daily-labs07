package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourierFileManagerTest {

    CourierFileManager courierFileManager = new CourierFileManager();

    Path validFilePath = Paths.get("src/test/resources/courier.txt");
    Path invalidFilePath = Paths.get("src/test/resources/badCourier.txt");
    Path nonExistentFile = Paths.get("src/test/resources/courier_.txt");

    @Test
    void createCourierByValidFileTest() {
        Courier courier = courierFileManager.createCourierByFile(validFilePath);
        assertEquals(6, courier.getRides().size());
        assertEquals(4, courier.getRides().get(3).getDayOfWeek());
        assertEquals(3, courier.getRides().get(5).getNumberOfRide());
        assertEquals(11, courier.getRides().get(1).getKms());
    }

    @Test
    void createCourierByInvalidFileTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> courierFileManager.createCourierByFile(invalidFilePath));
        assertEquals("Invalid parameters!", iae.getMessage());
    }

    @Test
    void createCourierByNonExistentFileTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> courierFileManager.createCourierByFile(nonExistentFile));
        assertEquals("Unable to read file!", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }
}