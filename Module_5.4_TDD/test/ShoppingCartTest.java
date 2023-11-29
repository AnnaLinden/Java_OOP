import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItem() {
        cart.addItem(new Item("Apple", 1.0));
        cart.addItem(new Item("Banana", 0.5));

        assertEquals(2, cart.getItemCount());
    }

    @Test
    void testRemoveItem() {
        cart.addItem(new Item("Apple", 1.0));
        cart.addItem(new Item("Banana", 0.5));
        cart.removeItem("Apple");

        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testCalculateTotal() {
        cart.addItem(new Item("Apple", 1.0));
        cart.addItem(new Item("Banana", 0.5));
        cart.addItem(new Item("Orange", 0.75));

        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }
}
