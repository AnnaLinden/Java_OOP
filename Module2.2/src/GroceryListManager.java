
// Task 4: Quantity Tracking
/*
 * Extend the GroceryListManager class to track the quantity of each item
 * in the list. Add the following methods:
 * 
 * addItemWithQuantity(String item, int quantity):
 * This method should add the given item along with its quantity to the grocery
 * list.
 * updateQuantity(String item, int newQuantity):
 * This method should update the quantity of the specified item in the grocery
 * list.
 * displayAvailableItems():
 * This method should display items along with their quantities that have a
 * positive quantity.
 */

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    // Inner class to hold item details
    private static class ItemDetails {
        double cost;
        String category;
        int quantity;

        ItemDetails(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Cost: $" + String.format("%.2f", cost) + ", Category: " + category + ", Quantity: " + quantity;
        }
    }

    // HashMap to hold the items with their details
    private HashMap<String, ItemDetails> groceryList = new HashMap<>();

    // Method to add an item with its cost and category
    public void addItemWithCategory(String item, double cost, String category) {
        groceryList.put(item, new ItemDetails(cost, category, 0)); // Quantity defaults to 0 when only category is
                                                                   // specified
    }

    // Method to add an item with its quantity, category, and cost
    public void addItemWithQuantity(String item, double cost, String category, int quantity) {
        groceryList.put(item, new ItemDetails(cost, category, quantity));
    }

    // Method to update the quantity of an item
    public void updateQuantity(String item, int newQuantity) {
        ItemDetails details = groceryList.get(item);
        if (details != null) {
            details.quantity = newQuantity;
        } else {
            System.out.println("Item does not exist in the list.");
        }
    }

    // Method to display items by category
    public void displayByCategory(String category) {
        System.out.println("Items in category '" + category + "':");
        for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
            if (entry.getValue().category.equalsIgnoreCase(category)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    // Method to display items with a positive quantity
    public void displayAvailableItems() {
        System.out.println("Available items:");
        for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
            if (entry.getValue().quantity > 0) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Add items with category and cost
        manager.addItemWithCategory("Bananas", 1.20, "Fruits");
        manager.addItemWithCategory("Yogurt", 0.80, "Dairy");

        // Display items by category
        manager.displayByCategory("Fruits");

        // Add items with quantity
        manager.addItemWithQuantity("Apples", 1.50, "Fruits", 5);
        manager.addItemWithQuantity("Milk", 0.99, "Dairy", 2);
        manager.addItemWithQuantity("Bread", 2.50, "Bakery", 3);

        // Display available items
        manager.displayAvailableItems();

        // Update the quantity of 'Milk'
        manager.updateQuantity("Milk", 5);

        // Display available items after the update
        manager.displayAvailableItems();
    }
}

// ___________________________________________________________________________________________
// Task 3: Categorizing Items
/*
 * Enhance the GroceryListManager class to support categorizing items. Each item
 * should belong to a category (e.g., "Fruits", "Dairy", "Bakery"). Add the
 * following methods:
 * 
 * addItemWithCategory(String item, String category): This method should add the
 * given item to the grocery list along with its category.
 * displayByCategory(String category): This method should display all items in
 * the specified category.
 */

/*
 * import java.util.HashMap;
 * import java.util.Map;
 * 
 * public class GroceryListManager {
 * // Inner class to hold item details
 * private static class ItemDetails {
 * double cost;
 * String category;
 * 
 * ItemDetails(double cost, String category) {
 * this.cost = cost;
 * this.category = category;
 * }
 * 
 * @Override
 * public String toString() {
 * return "Cost: $" + String.format("%.2f", cost) + ", Category: " + category;
 * }
 * }
 * 
 * // HashMap to hold the items with their details
 * private HashMap<String, ItemDetails> groceryList = new HashMap<>();
 * 
 * // Method to add an item with its cost and category
 * public void addItemWithCategory(String item, double cost, String category) {
 * if (!groceryList.containsKey(item)) {
 * groceryList.put(item, new ItemDetails(cost, category));
 * } else {
 * System.out.println("Item already exists in the list.");
 * }
 * }
 * 
 * // Method to remove an item
 * public void removeItem(String item) {
 * if (groceryList.containsKey(item)) {
 * groceryList.remove(item);
 * } else {
 * System.out.println("Cannot remove " + item +
 * " - item not found in the list.");
 * }
 * }
 * 
 * // Method to display items by category
 * public void displayByCategory(String category) {
 * System.out.println("Items in category '" + category + "':");
 * boolean categoryExists = false;
 * for (Map.Entry<String, ItemDetails> entry : groceryList.entrySet()) {
 * if (entry.getValue().category.equalsIgnoreCase(category)) {
 * System.out.println(entry.getKey() + " - " + entry.getValue());
 * categoryExists = true;
 * }
 * }
 * if (!categoryExists) {
 * System.out.println("No items found in this category.");
 * }
 * }
 * 
 * // Method to calculate total cost of the items
 * public void calculateTotalCost() {
 * double totalCost = 0;
 * for (ItemDetails details : groceryList.values()) {
 * totalCost += details.cost;
 * }
 * System.out.printf("Total cost: $%.2f%n", totalCost);
 * }
 * 
 * // Main method for demonstration
 * public static void main(String[] args) {
 * GroceryListManager manager = new GroceryListManager();
 * 
 * // Add items with category and cost
 * manager.addItemWithCategory("Apples", 1.50, "Fruits");
 * manager.addItemWithCategory("Bananas", 1.20, "Fruits");
 * manager.addItemWithCategory("Milk", 0.99, "Dairy");
 * manager.addItemWithCategory("Bread", 2.50, "Bakery");
 * 
 * // Display items by category
 * System.out.println("Displaying items by category:");
 * manager.displayByCategory("Fruits");
 * manager.displayByCategory("Dairy");
 * manager.displayByCategory("Bakery");
 * 
 * // Calculate and display the total cost
 * manager.calculateTotalCost();
 * 
 * // Remove an item and display the list again
 * System.out.println("\nRemoving 'Bananas' from the list...");
 * manager.removeItem("Bananas");
 * manager.displayByCategory("Fruits");
 * 
 * // Display the total cost after removing an item
 * manager.calculateTotalCost();
 * }
 * }
 */

// ___________________________________________________________________________________________
// Task 2: Total Cost Calculation

/*
 * Modify the GroceryListManager class to store both the item
 * name and its corresponding cost as a pair (e.g., using a
 * HashMap<String, Double>). Add the following methods:
 * 
 * addItem(String item, double cost): This method should add the given
 * item and its cost to the grocery list.
 * calculateTotalCost(): This method should calculate and
 * return the total cost of all items in the grocery list.
 */
/*
 * import java.util.HashMap;
 * import java.util.Map;
 * 
 * public class GroceryListManager {
 * private HashMap<String, Double> groceryList = new HashMap<>();
 * 
 * // Method to add an item with its cost to the list
 * public void addItem(String item, double cost) {
 * if (!groceryList.containsKey(item)) {
 * groceryList.put(item, cost);
 * } else {
 * System.out.println("Item already exists in the list.");
 * }
 * }
 * 
 * // Method to remove an item from the list
 * public void removeItem(String item) {
 * if (groceryList.containsKey(item)) {
 * groceryList.remove(item);
 * } else {
 * System.out.println("Cannot remove " + item +
 * " - item not found in the list.");
 * }
 * }
 * 
 * // Method to display all items and their costs in the list
 * public void displayList() {
 * System.out.println("You have " + groceryList.size() +
 * " items in your grocery list.");
 * System.out.println("Grocery List:");
 * int i = 1;
 * for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
 * System.out.println(i++ + ". " + entry.getKey() + " - $" + entry.getValue());
 * }
 * }
 * 
 * // Method to check if an item is in the list
 * public boolean checkItem(String item) {
 * return groceryList.containsKey(item);
 * }
 * 
 * // Method to calculate the total cost of all items in the list
 * public double calculateTotalCost() {
 * double totalCost = 0;
 * for (double cost : groceryList.values()) {
 * totalCost += cost;
 * }
 * return totalCost;
 * }
 * 
 * public static void main(String[] args) {
 * GroceryListManager manager = new GroceryListManager();
 * 
 * // Add items to the list with their costs
 * manager.addItem("Apples", 1.50);
 * manager.addItem("Milk", 0.99);
 * manager.addItem("Bread", 2.50);
 * 
 * // Display the list
 * manager.displayList();
 * 
 * // Calculate and display the total cost
 * System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());
 * 
 * // Check for "Milk" in the list
 * System.out.println("\nIs \"Milk\" in the grocery list? " +
 * manager.checkItem("Milk"));
 * 
 * // Remove "Milk" from the list
 * System.out.println("\nRemoving \"Milk\" from the list...");
 * manager.removeItem("Milk");
 * 
 * // Display the updated list
 * manager.displayList();
 * 
 * // Display the updated total cost
 * System.out.println("\nUpdated Total Cost: $" + manager.calculateTotalCost());
 * }
 * }
 */

// ___________________________________________________________________________________________
// Task 1
// import java.util.ArrayList;

// public class GroceryListManager {
// private ArrayList<String> groceryList = new ArrayList<>();

// public void addItem(String item) {
// if (!groceryList.contains(item)) {
// groceryList.add(item);
// } else {
// System.out.println("Item already exists in the list.");
// }
// }

// public void removeItem(String item) {
// if (groceryList.contains(item)) {
// groceryList.remove(item);
// } else {
// System.out.println("Cannot remove " + item + " - item not found in the
// list.");
// }
// }

// public void displayList() {
// System.out.println("You have " + groceryList.size() + " items in your grocery
// list.");
// System.out.println("Grocery List:");
// for (int i = 0; i < groceryList.size(); i++) {
// System.out.println((i + 1) + ". " + groceryList.get(i));
// }
// }

// public boolean checkItem(String item) {
// return groceryList.contains(item);
// }

// public static void main(String[] args) {
// GroceryListManager manager = new GroceryListManager();

// // Add items to the list
// manager.addItem("Apples");
// manager.addItem("Milk");
// manager.addItem("Bread");

// // Display the list
// manager.displayList();

// // Check for "Milk" in the list
// System.out.println("\nIs \"Milk\" in the grocery list? " +
// manager.checkItem("Milk"));

// // Remove "Milk" from the list
// System.out.println("\nRemoving \"Milk\" from the list...");
// manager.removeItem("Milk");

// // Display the updated list
// manager.displayList();
// }

// }