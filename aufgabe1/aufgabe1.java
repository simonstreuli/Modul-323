package aufgabe1;

public class aufgabe1 {
    public static void main(String[] args) {
        System.out.println(wordScore("asdasd"));
        System.out.println(calculateScore("noris"));
    }

    public static int wordScore(String word) {
        return (int) word.chars()
                .filter(c -> c != 'a' && c != 'A')
                .count();
    }

    public static int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            if (c != 'a' && c != 'A') {
                score++;
            }
        }
        return score;
    }
}