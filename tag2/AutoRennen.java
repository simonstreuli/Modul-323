package tag2;

import java.util.*;

public class AutoRennen {

    public static int berechneGesamtzeit(List<Integer> rundenZeiten) {
        // Warm-up Runde (erste Runde) wird ignoriert
        return rundenZeiten.subList(1, rundenZeiten.size())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double berechneDurchschnittszeit(List<Integer> rundenZeiten) {
        if (rundenZeiten.size() <= 1)
            return 0;
        return berechneGesamtzeit(rundenZeiten) / (double) (rundenZeiten.size() - 1);
    }

    // Beispielverwendung
    public static void main(String[] args) {
        Map<String, List<Integer>> zeiten = Map.of(
                "Auto1", List.of(90, 85, 87, 88),
                "Auto2", List.of(92, 83, 80, 84));

        for (String auto : zeiten.keySet()) {
            List<Integer> runden = zeiten.get(auto);
            System.out.println(auto + " Gesamtzeit: " + berechneGesamtzeit(runden));
            System.out.printf(auto + " Durchschnitt: %.2f Sekunden%n", berechneDurchschnittszeit(runden));
        }
    }
}
