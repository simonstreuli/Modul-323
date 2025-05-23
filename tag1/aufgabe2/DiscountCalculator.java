package aufgabe2;

import java.util.List;

public class DiscountCalculator {
    public static double getDiscountPercentage(List<String> items) {
        return items.stream().anyMatch(item -> item.equalsIgnoreCase("book")) ? 5.0 : 0.0;
    }
}