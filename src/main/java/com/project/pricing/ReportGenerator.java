package com.project.pricing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
    public void generateReport(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.md"))) {
            writer.write("# Pricing Report\n");
            writer.write("This report compares internal prices with market data.\n\n");

            writer.write("| Product            | Our Price      | Category  |\n");
            writer.write("|--------------------|----------------|-----------|\n");

            for (Product product : products) {
                writer.write("| " + product.getName() +
                        " | $" + product.getPrice() +
                        " | " + product.getCategory() + " |\n");
            }

            writer.write("\n**Note:** Market prices are simulated for this test.\n");
            System.out.println("Report saved to report.md.");
        } catch (IOException e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
}
