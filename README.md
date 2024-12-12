# Product Pricing Tool

This project is a tool that helps a small business owner track their product pricing against market conditions. The tool reads product data from a CSV file, integrates simulated market prices, and generates a report comparing the prices.

## Features
- Reads product data from a CSV file.
- Simulates market price comparison based on product name.
- Generates a markdown report with the pricing comparison.

## Requirements
- **Java 8+**
- **Maven** (for dependency management and project building)

## Setup
### Run
Execute the commands:
mvn clean compile
mvn exec:java -Dexec.mainClass="com.project.pricing.App"

### Clone the Repository

Start by cloning the repository to your local machine:
```bash
git clone https://github.com/yourusername/product-pricing-tool.git
cd product-pricing-tool

