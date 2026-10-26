import java.util.ArrayList;
import java.util.Scanner;

// Product Class
class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

// Main Class
public class ElectronicStore {

    static ArrayList<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Product
    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        productList.add(new Product(id, name, price, quantity));
        System.out.println("Product Added Successfully!");
    }

    // View Products
    public static void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }

        System.out.println("\\n--- Product List ---");
        for (Product p : productList) {
            System.out.println("ID: " + p.id +
                               ", Name: " + p.name +
                               ", Price: " + p.price +
                               ", Quantity: " + p.quantity);
        }
    }

    // Update Product
    public static void updateProduct() {
        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();

        for (Product p : productList) {
            if (p.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                p.name = sc.nextLine();

                System.out.print("Enter New Price: ");
                p.price = sc.nextDouble();

                System.out.print("Enter New Quantity: ");
                p.quantity = sc.nextInt();

                System.out.println("Product Updated Successfully!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    // Delete Product
    public static void deleteProduct() {
        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();

        for (Product p : productList) {
            if (p.id == id) {
                productList.remove(p);
                System.out.println("Product Deleted Successfully!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    // Billing
    public static void billing() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : productList) {
            if (p.id == id) {
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                if (qty <= p.quantity) {
                    double total = qty * p.price;
                    p.quantity -= qty;

                    System.out.println("Total Bill: " + total);
                    System.out.println("Transaction Successful!");
                } else {
                    System.out.println("Insufficient Stock!");
                }
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    // Main Method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\\n===== Electronic Store Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Billing");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    billing();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
}
