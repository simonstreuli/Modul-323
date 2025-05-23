package tag2;

import java.util.*;

public class WortBewertung {

    public static int berechnePunkte(String wort) {
        int punkte = 0;
        for (char buchstabe : wort.toLowerCase().toCharArray()) {
            if (buchstabe != 'a') {
                punkte++;
            }
        }
        return punkte;
    }

    public static List<String> sortiereWoerterNachPunkten(List<String> woerter) {
        return woerter.stream()
                .sorted((w1, w2) -> Integer.compare(berechnePunkte(w2), berechnePunkte(w1)))
                .toList();
    }

    // Beispielverwendung
    public static void main(String[] args) {
        List<String> woerter = List.of("Apfel", "Banane", "Zug", "Auto", "Brot");
        List<String> sortiert = sortiereWoerterNachPunkten(woerter);

        for (String wort : sortiert) {
            System.out.println(wort + " = " + berechnePunkte(wort) + " Punkte");
        }
    }
}
