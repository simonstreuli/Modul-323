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

    public List<Task> addTask(List<Task> tasks, Task newTask) {
        return List.copyOf(tasks).stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            list.add(newTask);
                            return List.copyOf(list);
                        }));
    }

    public List<Task> deleteTask(List<Task> tasks, Task toDelete) {
        return tasks.stream()
                .filter(task -> !task.equals(toDelete))
                .collect(Collectors.toUnmodifiableList());
    }
}
