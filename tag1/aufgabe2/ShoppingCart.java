package aufgabe2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;
    private boolean bookAdded;

    public ShoppingCart() {
        items = new ArrayList<>();
        bookAdded = false;
    }

    public void addItem(String item) {
        items.add(item);
        if (item.equalsIgnoreCase("book")) {
            bookAdded = true;
        }
    }

    public void removeItem(String item) {
        items.remove(item);
        bookAdded = items.stream().anyMatch(i -> i.equalsIgnoreCase("book"));
    }

    public List<String> getItems() {
        return items;
    }

    public double getDiscountPercentage() {
        return bookAdded ? 5.0 : 0.0;
    }
}