import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        return items.values().stream().mapToDouble(Item::getPrice).sum();
    }
}
