package project.model;

import java.util.List;

public record Category(
        String name,
        List<String> subcategories) {
}
