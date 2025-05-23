// ===========================================
// Aufgabe 1: Beurteilung pure vs. impure Functions (Java)
// ===========================================
// Dokumentation (z.B. für README.md):
/*
| Aufgabe | Nur Rückgabewert | Nur abhängig von Parametern | Keine Seiteneffekte | pure/impure |
|--------|-------------------|------------------------------|---------------------|-------------|
| 1.1    | ✅                | ❌                           | ❌                  | impure      |
| 1.2    | ✅                | ✅                           | ✅                  | pure        |
| 1.3    | ✅                | ✅                           | ✅                  | pure        |
| 1.4    | ✅                | ❌                           | ✅                  | impure      |
| 1.5    | ✅                | ✅                           | ✅                  | pure        |
| 1.6    | ✅                | ✅                           | ❌                  | impure      |
*/

package tag2.purefunctions;

import java.util.*;

// ===========================================
// Aufgabe 2: Umschreiben in pure functions
// ===========================================

public class PureFunctionsJava {

    public static List<String> addToCartPure(List<String> cart, String item) {
        List<String> newCart = new ArrayList<>(cart);
        newCart.add(item);
        return newCart;
    }

    public static double multiplyWithRandomPure(double number, double randomValue) {
        return number * randomValue;
    }

    public static String returnString(String str) {
        return str;
    }

    public static char firstCharacter(String str) {
        if (str != null && !str.isEmpty()) {
            return str.charAt(0);
        }
        return '?';
    }

    public static double divideNumbers(double dividend, double divisor) {
        if (Double.isNaN(dividend) || Double.isNaN(divisor)) {
            return Double.NaN;
        }

        if (divisor == 0.0) {
            return Double.POSITIVE_INFINITY;
        }

        return dividend / divisor;
    }

    // ===========================================
    // Aufgabe 3: Eigene pure rekursive Funktionen
    // ===========================================

    public static int sumList(List<Integer> nums) {
        if (nums.isEmpty())
            return 0;
        return nums.get(0) + sumList(nums.subList(1, nums.size()));
    }

    public static double averageList(List<Integer> nums) {
        if (nums.isEmpty())
            return 0.0;
        return sumList(nums) / (double) nums.size();
    }

    public static List<String> sortStrings(List<String> list) {
        if (list.isEmpty())
            return list;
        String head = list.get(0);
        List<String> tailSorted = sortStrings(list.subList(1, list.size()));
        return insertString(head, tailSorted);
    }

    private static List<String> insertString(String x, List<String> sorted) {
        List<String> result = new ArrayList<>();
        boolean inserted = false;
        for (String s : sorted) {
            if (!inserted && x.compareTo(s) <= 0) {
                result.add(x);
                inserted = true;
            }
            result.add(s);
        }
        if (!inserted)
            result.add(x);
        return result;
    }

    static class Task {
        String datum;
        int prioritaet;
        String titel;

        public Task(String datum, int prioritaet, String titel) {
            this.datum = datum;
            this.prioritaet = prioritaet;
            this.titel = titel;
        }
    }

    public static List<Task> sortTasks(List<Task> tasks) {
        if (tasks.isEmpty())
            return tasks;
        Task head = tasks.get(0);
        List<Task> tailSorted = sortTasks(tasks.subList(1, tasks.size()));
        return insertTask(head, tailSorted);
    }

    private static List<Task> insertTask(Task t, List<Task> sorted) {
        List<Task> result = new ArrayList<>();
        boolean inserted = false;
        for (Task task : sorted) {
            if (!inserted && compareTasks(t, task)) {
                result.add(t);
                inserted = true;
            }
            result.add(task);
        }
        if (!inserted)
            result.add(t);
        return result;
    }

    private static boolean compareTasks(Task a, Task b) {
        int cmpDate = a.datum.compareTo(b.datum);
        if (cmpDate != 0)
            return cmpDate < 0;
        if (a.prioritaet != b.prioritaet)
            return a.prioritaet < b.prioritaet;
        return a.titel.compareTo(b.titel) < 0;
    }

    interface Tree {
    }

    static class Leaf implements Tree {
        String value;

        public Leaf(String value) {
            this.value = value;
        }
    }

    static class Node implements Tree {
        List<Tree> children;

        public Node(List<Tree> children) {
            this.children = children;
        }
    }

    public static List<String> extractLeaves(Tree tree) {
        if (tree instanceof Leaf leaf) {
            return List.of(leaf.value);
        } else if (tree instanceof Node node) {
            List<String> leaves = new ArrayList<>();
            for (Tree child : node.children) {
                leaves.addAll(extractLeaves(child));
            }
            return leaves;
        }
        return List.of();
    }
}
