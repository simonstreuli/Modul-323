package project.model;

import java.time.LocalDate;

public record Task(
        String title,
        String description,
        LocalDate deadline,
        String category) {
}
