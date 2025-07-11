package tag3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgaben {

    public List<Integer> aufgabe1() {
        List<Integer> zahlen = Arrays.asList(1, 2, 3, 4, 5);
        return zahlen.stream()
                .map(z -> z * 2)
                .collect(Collectors.toList());
    }

    public List<String> aufgabe2() {
        List<String> namen = Arrays.asList("Alice", "Bob", "Charlie");
        return namen.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<Double> aufgabe3() {
        List<Integer> zahlen = Arrays.asList(12, 45, 68, 100);
        return zahlen.stream()
                .map(z -> z / 2.0)
                .collect(Collectors.toList());
    }

    public static class Adresse {
        String strasse;
        int hausnummer;
        String postleitzahl;
        String stadt;

        public Adresse(String strasse, int hausnummer, String postleitzahl, String stadt) {
            this.strasse = strasse;
            this.hausnummer = hausnummer;
            this.postleitzahl = postleitzahl;
            this.stadt = stadt;
        }
    }

    public List<String> aufgabe4() {
        List<Adresse> adressen = Arrays.asList(
                new Adresse("Hauptstrasse", 10, "12345", "Musterstadt"),
                new Adresse("Nebenstrasse", 5, "23456", "Beispielburg"));

        return adressen.stream()
                .map(a -> a.strasse + " " + a.hausnummer + ", " + a.postleitzahl + " " + a.stadt)
                .collect(Collectors.toList());
    }

    public List<String> aufgabe5() {
        List<String> namen = Arrays.asList("Max Mustermann", "Erika Mustermann");
        return namen.stream()
                .map(n -> n.split(" ")[0].toUpperCase())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Aufgaben aufgaben = new Aufgaben();

        System.out.println("Aufgabe 1: " + aufgaben.aufgabe1());
        System.out.println("Aufgabe 2: " + aufgaben.aufgabe2());
        System.out.println("Aufgabe 3: " + aufgaben.aufgabe3());
        System.out.println("Aufgabe 4: " + aufgaben.aufgabe4());
        System.out.println("Aufgabe 5: " + aufgaben.aufgabe5());
    }
}
