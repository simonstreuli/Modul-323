package aufgabe3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Imperative Version
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("pen");
        cart.addItem("book");
        System.out.println("Warenkorb: " + cart.getItems());
        System.out.println("Rabatt (imperativ): " + cart.getDiscountPercentage() + "%");

        cart.removeItem("book");
        System.out.println("Warenkorb nach Entfernen: " + cart.getItems());
        System.out.println("Rabatt (imperativ): " + cart.getDiscountPercentage() + "%");

        // Funktionale Version
        System.out.println("Rabatt (funktional, mit book): " +
                DiscountCalculator.getDiscountPercentage(Arrays.asList("book", "pen")) + "%");
        System.out.println("Rabatt (funktional, ohne book): " +
                DiscountCalculator.getDiscountPercentage(Arrays.asList("pen", "notebook")) + "%");
    }
}