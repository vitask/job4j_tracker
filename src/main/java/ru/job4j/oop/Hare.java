package ru.job4j.oop;

public class Hare {
    public void tryEat(Ball ball) {
        System.out.println("Встретился заяц.");
        ball.tryRun(false);
    }
}
