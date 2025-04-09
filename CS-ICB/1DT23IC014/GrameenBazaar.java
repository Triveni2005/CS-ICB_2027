import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------------");
    }
}

public class GrameenBazaar {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to GrameenBazaar");

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct(scanner);
                case 2 -> viewProducts();
                case 3 -> System.out.println("Thank you for using GrameenBazaar!");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 3);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter price: ₹");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        products.add(new Product(name, description, price));
        System.out.println("Product added successfully.");
    }

    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product product : products) {
                product.display();
            }
        }
    }
}