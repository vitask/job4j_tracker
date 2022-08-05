package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {

        private final String name;
        private final long sent;

        public Task(String name, long sent) {
            this.name = name;
            this.sent = sent;
        }

    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug #1", 100),
                new Task("Task #2", 200),
                new Task("Bug #3", 400)
        );
        tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).filter(
                task -> task.sent > 300
        ).map(
                task -> task.name + " " + task.sent
        ).forEach(System.out::println);
    }
}
