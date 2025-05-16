package aufgabe2;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Tip (0 Personen): " +
            TipCalculator.calculateTipPercentage(Collections.emptyList()) + "%");

        System.out.println("Tip (3 Personen): " +
            TipCalculator.calculateTipPercentage(Arrays.asList("Anna", "Ben", "Clara")) + "%");

        System.out.println("Tip (6 Personen): " +
            TipCalculator.calculateTipPercentage(Arrays.asList("A", "B", "C", "D", "E", "F")) + "%");
    }
}
