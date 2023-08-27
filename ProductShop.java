import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductShop {
    private static Map<String, Double> products = new HashMap<>();

    public static void main(String[] args) {
        // Adding some sample products
        addProduct("apple", 1.0);
        addProduct("banana", 0.8);
        addProduct("orange", 1.2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Product Shop!");

        while (true) {
            System.out.println("\n1. Add product");
            System.out.println("2. Calculate bill");
            System.out.println("3. Check quantity");
            System.out.println("4. Check registered user");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProductOperation(scanner);
                    break;
                case 2:
                    calculateBillOperation(scanner);
                    break;
                case 3:
                    checkQuantityOperation(scanner);
                    break;
                case 4:
                    checkRegisteredUserOperation(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the Product Shop!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProductOperation(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.next();
        System.out.print("Enter the product price: ");
        double productPrice = scanner.nextDouble();
        addProduct(productName, productPrice);
        System.out.println(productName + " added to the product list.");
    }

    private static void calculateBillOperation(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        if (!isUserRegistered(username)) {
            System.out.println("User not registered. Please register before making a purchase.");
            return;
        }

        Map<String, Integer> cart = new HashMap<>();
        boolean done = false;
        while (!done) {
            System.out.print("Enter product name (or 'done' to finish shopping): ");
            String productName = scanner.next();

            if (productName.equalsIgnoreCase("done")) {
                done = true;
            } else {
                if (!products.containsKey(productName)) {
                    System.out.println("Product not found.");
                } else {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
                }
            }
        }

        double totalAmount = 0;
        System.out.println("\nCart Summary:");
        for (String product : cart.keySet()) {
            int quantity = cart.get(product);
            double price = products.get(product);
            double subtotal = quantity * price;
            System.out.printf("%s - %d x %.2f = %.2f\n", product, quantity, price, subtotal);
            totalAmount += subtotal;
        }

        System.out.println("\nTotal Amount: " + totalAmount);
    }

    private static void checkQuantityOperation(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.next();
        if (products.containsKey(productName)) {
            System.out.println(productName + " available in stock.");
        } else {
            System.out.println(productName + " not found in stock.");
        }
    }

    private static void checkRegisteredUserOperation(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        if (isUserRegistered(username)) {
            System.out.println("User " + username + " is registered.");
        } else {
            System.out.println("User " + username + " is not registered.");
        }
    }

    private static void addProduct(String productName, double price) {
        products.put(productName, price);
    }

    private static boolean isUserRegistered(String username) {
        // Replace this with your actual user registration logic, e.g., check against a database.
        // For this example, let's assume all usernames are registered.
        return true;
    }
}
