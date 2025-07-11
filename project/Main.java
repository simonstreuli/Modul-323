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
                new Task("Einkaufen", "Milch und Brot", LocalDate.of(2025, 7, 5), "Privat"),
                new Task("Code Review", "Pull Request prüfen", LocalDate.of(2025, 7, 11), "Arbeit"),
                new Task("Hausaufgaben", "Matheaufgaben Seite 52", LocalDate.of(2025, 7, 13), "Studium"),
                new Task("Joggen", "5 km Lauf im Park", LocalDate.of(2025, 7, 12), "Fitness"),
                new Task("Meeting vorbereiten", "Folien für Präsentation erstellen", LocalDate.of(2025, 7, 9),
                        "Arbeit"),
                new Task("Geburtstagsgeschenk kaufen", "Für Maria", LocalDate.of(2025, 7, 8), "Privat"),
                new Task("Fitnessstudio", "Krafttraining Beine", LocalDate.of(2025, 7, 6), "Fitness"),
                new Task("Studium: Vortrag üben", "Vortrag zur KI-Thematik einstudieren", LocalDate.of(2025, 7, 14),
                        "Studium"),
                new Task("Steuererklärung", "Unterlagen zusammenstellen", LocalDate.of(2025, 7, 20), "Privat"));

        // Filter nach Kategorie
        List<Task> arbeit = service.filterByCategory(tasks, "Arbeit");

        System.out.println("=== Gefilterte Aufgaben (Kategorie: Arbeit) ===");
        printTasks(arbeit);

        // Speichern
        FileStorage.saveTasks(tasks, "tasks.json");
        System.out.println("\n✅ Aufgaben erfolgreich gespeichert in 'tasks.json'.");

        // Laden
        List<Task> loaded = FileStorage.loadTasks("tasks.json");
        System.out.println("\n=== Geladene Aufgaben aus Datei ===");
        printTasks(loaded);

        // Zusatz: rekursives Zählen
        int count = service.countTasksRecursively(loaded);
        System.out.println("\n📊 Gesamtanzahl geladener Aufgaben (rekursiv gezählt): " + count);
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
                    Titel       : %s
                    Beschreibung: %s
                    Deadline    : %s
                    Kategorie   : %s
                    ----------------------------------%n""",
                    i + 1,
                    t.title(),
                    t.description(),
                    t.deadline(),
                    t.category());
        }
    }
}
