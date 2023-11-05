//Task 2: Total Cost Calculation

/*
 * Modify the GroceryListManager class to store both the item 
 * name and its corresponding cost as a pair (e.g., using a 
 * HashMap<String, Double>). Add the following methods:

addItem(String item, double cost): This method should add the given 
                                    item and its cost to the grocery list.
calculateTotalCost(): This method should calculate and 
                        return the total cost of all items in the grocery list.
 */

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    // Method to add an item with its cost to the list
    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, cost);
        } else {
            System.out.println("Item already exists in the list.");
        }
    }

    // Method to remove an item from the list
    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
        } else {
            System.out.println("Cannot remove " + item + " - item not found in the list.");
        }
    }

    // Method to display all items and their costs in the list
    public void displayList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");
        System.out.println("Grocery List:");
        int i = 1;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            System.out.println(i++ + ". " + entry.getKey() + " - $" + entry.getValue());
        }
    }

    // Method to check if an item is in the list
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // Method to calculate the total cost of all items in the list
    public double calculateTotalCost() {
        double totalCost = 0;
        for (double cost : groceryList.values()) {
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Add items to the list with their costs
        manager.addItem("Apples", 1.50);
        manager.addItem("Milk", 0.99);
        manager.addItem("Bread", 2.50);

        // Display the list
        manager.displayList();

        // Calculate and display the total cost
        System.out.println("\nTotal Cost: $" + manager.calculateTotalCost());

        // Check for "Milk" in the list
        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        // Remove "Milk" from the list
        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Display the updated list
        manager.displayList();

        // Display the updated total cost
        System.out.println("\nUpdated Total Cost: $" + manager.calculateTotalCost());
    }
}

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