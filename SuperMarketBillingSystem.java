package supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class SuperMarketBillingSystem {
    private static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Edit Item Price");
            System.out.println("3. Remove Item");
            System.out.println("4. Calculate Total Bill");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    editItemPrice(scanner);
                    break;
                case 3:
                    removeItem(scanner);
                    break;
                case 4:
                    calculateTotalBill();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.next();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        Item item = new Item(name, price);
        items.add(item);

        System.out.println("Item added successfully!");
    }

    private static void editItemPrice(Scanner scanner) {
        System.out.print("Enter item name to edit price: ");
        String name = scanner.next();

        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                item.setPrice(newPrice);
                System.out.println("Price updated successfully!");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("Enter item name to remove: ");
        String name = scanner.next();

        Item itemToRemove = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void calculateTotalBill() {
        double totalBill = 0.0;
        for (Item item : items) {
            totalBill += item.getPrice();
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}

