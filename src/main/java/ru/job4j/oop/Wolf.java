package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball) {
        System.out.println("Встретился волк.");
        ball.tryRun(false);
    }
}
