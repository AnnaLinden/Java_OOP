import java.util.ArrayList;
import java.util.List;

// A separate class to represent a shopping list
public class ShoppingList {
    private String name;
    private List<String> items;

    public ShoppingList(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Method to add an item to the list
    public void addItem(String item) {
        items.add(item);
    }

    // Method to remove an item from the list
    public void removeItem(String item) {
        items.remove(item);
    }

    // Method to display the shopping list
    public void displayList() {
        System.out.println(name + " Shopping List:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

}

/**
 * ShoppingListTest
 */
class ShoppingListTest {
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();
        ShoppingList bbqList = new ShoppingList("Backyard BBQ");
        ShoppingList campingList = new ShoppingList("Weekend Camping");

        // Add items to shopping lists
        bbqList.addItem("Charcoal");
        campingList.addItem("Tent");

        // Display shopping lists
        bbqList.displayList();
        campingList.displayList();

    }
}