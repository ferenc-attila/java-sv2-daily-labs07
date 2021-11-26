package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (LocalDate.now().compareTo(product.getDateOfSell()) < 0) {
            throw new IllegalArgumentException("Invalid date" + product.getDateOfSell().toString());
        } else {
            products.add(product);
        }
    }

    public void writeSoldProductInThisMonth(int month) {
        List<Product> soldProductsThisMonth = getSoldProductsThisMonth(month);
        List<String> fileContent = createFileContent(soldProductsThisMonth);
        writeCsv(month, fileContent);
    }

    private void writeCsv(int month, List<String> fileContent) {
        String fileName = "soldProductsInMonth" + month;
        try {
            Files.write(Path.of("src/main/resources/").resolve(fileName), fileContent);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file", ioe);
        }
    }

    private List<String> createFileContent(List<Product> soldProductsThisMonth) {
        List<String> fileContent = new ArrayList<>();
        for (Product product : soldProductsThisMonth) {
            String row = product.toString();
            fileContent.add(row);
        }
        return fileContent;
    }

    private List<Product> getSoldProductsThisMonth(int month) {
        List<Product> soldProductsThisMonth = new ArrayList<>();
        for (Product product : products) {
            if (product.getDateOfSell().getYear() == LocalDate.now().getYear() && product.getDateOfSell().getMonthValue() == month) {
                soldProductsThisMonth.add(product);
            }
        }
        return soldProductsThisMonth;
    }
}
