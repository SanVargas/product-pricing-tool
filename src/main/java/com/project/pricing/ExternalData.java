package com.project.pricing;

import org.apache.http.client.fluent.Request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExternalData {
    public double fetchMarketPrice(String productName) {
        System.out.println("Fetching simulated market price for: " + productName);

        switch (productName.toLowerCase()) {
            case "coffee beans (1lb)":
                return 13.50;
            case "green tea (50 bags)":
                return 9.20;
            case "chai latte mix":
                return 10.00;
            default:
                return 15.00;
        }
    }
}
