package tag2;

import java.util.*;

public class ReisePlaner {
    private List<String> route = new ArrayList<>();

    public void addDestination(String destination) {
        route.add(destination);
    }

    public void updateDestination(int index, String newDestination) {
        if (index >= 0 && index < route.size()) {
            route.set(index, newDestination);
        } else {
            System.out.println("Ungültiger Index!");
        }
    }

    public List<String> getRoute() {
        return route;
    }

    // Beispielverwendung
    public static void main(String[] args) {
        ReisePlaner planer = new ReisePlaner();
        planer.addDestination("Paris");
        planer.addDestination("Rom");
        planer.addDestination("Berlin");

        System.out.println("Route: " + planer.getRoute());

        planer.updateDestination(1, "Florenz");
        System.out.println("Geänderte Route: " + planer.getRoute());
    }
}
