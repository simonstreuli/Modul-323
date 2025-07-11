package project;

import project.model.Task;
import project.service.TaskService;
import project.util.FileStorage;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskService service = new TaskService();

        List<Task> tasks = List.of(
                new Task("Projekt starten", "Setup und Planung", LocalDate.of(2025, 7, 10), "Arbeit"),
                new Task("Einkaufen", "Milch und Brot", LocalDate.of(2025, 7, 5), "Privat"));

        // Filter nach Kategorie
        List<Task> arbeit = service.filterByCategory(tasks, "Arbeit");

        System.out.println("=== Gefilterte Aufgaben (Kategorie: Arbeit) ===");
        printTasks(arbeit);

        // Speichern
        FileStorage.saveTasks(tasks, "tasks.csv");
        System.out.println("\n✅ Aufgaben erfolgreich gespeichert in 'tasks.csv'.");

        // Laden
        List<Task> loaded = FileStorage.loadTasks("tasks.csv");
        System.out.println("\n=== Geladene Aufgaben aus Datei ===");
        printTasks(loaded);
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("⚠️  Keine Aufgaben gefunden.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("""
                    ----------------------------------
                    Aufgabe #%d
                    Titel      : %s
                    Beschreibung: %s
                    Deadline   : %s
                    Kategorie  : %s
                    ----------------------------------%n""",
                    i + 1,
                    t.title(),
                    t.description(),
                    t.deadline(),
                    t.category());
        }
    }
}
