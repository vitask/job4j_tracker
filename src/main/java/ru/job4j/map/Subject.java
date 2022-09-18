package ru.job4j.map;

public record Subject(String name, int score) {

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}