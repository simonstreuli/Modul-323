package project.util;

import project.model.Task;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    public static void saveTasks(List<Task> tasks, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.title() + ";" +
                        task.description() + ";" +
                        task.deadline() + ";" +
                        task.category());
                writer.newLine();
            }
        }
    }

    public static List<Task> loadTasks(String filename) throws IOException {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    tasks.add(new Task(
                            parts[0],
                            parts[1],
                            LocalDate.parse(parts[2]),
                            parts[3]));
                }
            }
        }
        return tasks;
    }
}