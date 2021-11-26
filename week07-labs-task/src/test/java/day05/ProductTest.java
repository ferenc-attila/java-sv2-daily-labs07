package day05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product jeans = new Product("jeans",LocalDate.parse("2021-05-01"), 12_000);
    Product tShirt = new Product("t-shirt", LocalDate.parse("2021-05-16"), 5_000);
    Product skirt = new Product("skirt", LocalDate.parse("2021-06-04"), 14_000);
    Product sweater = new Product("sweater", LocalDate.parse("2021-05-20"), 15_000);

    @Test
    void initTest() {
        Product product = new Product("coat", LocalDate.parse("2021-10-12"), 45_000);
        assertEquals("coat;2021-10-12;45000",product.toString());
    }

    @Test
    void getNameTest() {
        assertEquals("jeans", jeans.getName());
    }

    @Test
    void testToStringTest() {
        assertEquals("sweater;2021-05-20;15000",sweater.toString());
    }

    @Test
    void getDateOfSellTest() {
        assertEquals("2021-05-16", tShirt.getDateOfSell().toString());
    }

    @Test
    void getPriceTest() {
        assertEquals(14000, skirt.getPrice());
    }
}