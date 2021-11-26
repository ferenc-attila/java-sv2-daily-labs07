package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (product.getDateOfSell().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date: " + product.getDateOfSell().toString());
        }
        products.add(product);
    }

    public String writeSoldProductInThisMonth(Month month, Path dir) {
        List<String> fileContent = createFileContent(month);
        return writeCsv(month, fileContent, dir);
    }

    private String writeCsv(Month month, List<String> fileContent, Path dir) {
        StringBuilder fileName = new StringBuilder("soldProducts_").append(month.toString());
        Path path = dir.resolve(fileName.toString());
        try {
            Files.write(path, fileContent);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file!", ioe);
        }
        return fileName.toString();
    }

    private List<String> createFileContent(Month month) {
        List<String> fileContent = new ArrayList<>();
        for (Product product : products) {
            if (product.getDateOfSell().getYear() == LocalDate.now().getYear() && product.getDateOfSell().getMonth() == month) {
                fileContent.add(product.toString());
            }
        }
        return fileContent;
    }
}
