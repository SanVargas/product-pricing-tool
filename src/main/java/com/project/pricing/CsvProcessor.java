package com.project.pricing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {
    public List<Product> readCsv(String filePath) throws IOException, CsvValidationException {
        List<Product> products = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Skip the first line (header)
            String[] header = reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                try {
                    String name = line[0];
                    double price = parsePrice(line[1]);
                    String category = line[2].trim();

                    products.add(new Product(name, price, category));
                } catch (Exception e) {
                    System.err.println("Error processing line: " + String.join(", ", line));
                }
            }
        }

        System.out.println("CSV file processed successfully.");
        return products;
    }

    private double parsePrice(String priceStr) {
        if (priceStr == null || priceStr.isEmpty() || priceStr.equalsIgnoreCase("out of stock")) {
            return -1.0; // Invalid price indicator
        }
        return Double.parseDouble(priceStr.replace("$", "").trim());
    }
}
