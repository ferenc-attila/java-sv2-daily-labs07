package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreTest {

    Store store = new Store();

    @TempDir
    File tempDir;

    @BeforeEach
    void init() {
        store.addProduct(new Product("jeans", LocalDate.parse("2021-05-01"), 12_000));
        store.addProduct(new Product("t-shirt", LocalDate.parse("2021-05-16"), 5_000));
        store.addProduct(new Product("skirt", LocalDate.parse("2021-06-04"), 14_000));
        store.addProduct(new Product("sweater", LocalDate.parse("2021-05-20"), 15_000));
    }

    @Test
    void addProductWithValidDateTest() {
        store.addProduct(new Product("coat", LocalDate.parse("2021-10-12"), 45_000));
        store.addProduct(new Product("coat", LocalDate.now().minusDays(1), 30_000));
        store.addProduct(new Product("shirt", LocalDate.now(), 12_000));
        assertEquals(7, store.getProducts().size());
        assertEquals(LocalDate.parse("2021-10-12"), store.getProducts().get(4).getDateOfSell());
        assertEquals("coat", store.getProducts().get(5).getName());
        assertEquals(12_000, store.getProducts().get(6).getPrice());
    }

    @Test
    void addProductWithInvalidDateTest() {
        Product shirt = new Product("shirt", LocalDate.now().plusDays(1), 12_000);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> store.addProduct(shirt));
        assertEquals("Invalid date: " + LocalDate.now().plusDays(1), iae.getMessage());
    }

    @Test
    void writeSoldProductInThisMonthValidFileTest() throws IOException {
        String fileName = store.writeSoldProductInThisMonth(Month.MAY, tempDir.toPath());
        List<String> result = Files.readAllLines(tempDir.toPath().resolve(fileName));
        assertEquals("soldProducts_MAY", fileName);
        assertEquals(3, result.size());
        assertEquals("sweater", result.get(2).split(";")[0]);
        assertEquals("2021-05-01", result.get(0).split(";")[1]);
        assertEquals(5000, Integer.parseInt(result.get(1).split(";")[2]));
    }

    @Test
    void writeSoldProductInThisMonthInvalidFileTest() {
        Path dir = Paths.get("M;/");
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> store.writeSoldProductInThisMonth(Month.MAY, dir));
        assertEquals("Unable to write file!", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }
}