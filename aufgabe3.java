import java.util.List;

public class aufgabe3 {
    public static int calculateTipPercentage(List<String> names) {
        int size = names.size();

        if (size == 0) {
            return 0;
        } else if (size > 5) {
            return 20;
        } else {
            return 10;
        }
    }
}
