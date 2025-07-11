package project.service;

import project.model.Task;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    public List<Task> filterByCategory(List<Task> tasks, String category) {
        return tasks.stream()
                .filter(task -> task.category().equalsIgnoreCase(category))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Task> filterByDateBefore(List<Task> tasks, LocalDate date) {
        return tasks.stream()
                .filter(task -> task.deadline().isBefore(date))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getTitlesBeforeDate(List<Task> tasks, LocalDate date) {
        return tasks.stream()
                .filter(task -> task.deadline().isBefore(date))
                .map(Task::title)
                .collect(Collectors.toList());
    }

    public int countTasksRecursively(List<Task> tasks) {
        if (tasks.isEmpty())
            return 0;
        return 1 + countTasksRecursively(tasks.subList(1, tasks.size()));
    }
}