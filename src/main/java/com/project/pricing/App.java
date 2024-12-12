package com.project.pricing;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Starting pricing tool...");
        String csvPath = "src/main/resources/products.csv";
        try {
            // Process the CSV
            CsvProcessor processor = new CsvProcessor();
            List<Product> products = processor.readCsv(csvPath);

            System.out.println("\nProcessed products:");
            for (Product product : products) {
                System.out.println(product);
            }

            // Generate the report
            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.generateReport(products); // Call to generate the report
            System.out.println("\nReport generated in product-pricing-tool/report.md");

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error processing data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("General error: " + e.getMessage());
        }
    }
}

