import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
        } else {
            System.out.println("Item already exists in the list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
        } else {
            System.out.println("Cannot remove " + item + " - item not found in the list.");
        }
    }

    public void displayList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Add items to the list
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        // Display the list
        manager.displayList();

        // Check for "Milk" in the list
        System.out.println("\nIs \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        // Remove "Milk" from the list
        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // Display the updated list
        manager.displayList();
    }

}