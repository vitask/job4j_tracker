package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void nameVehicle(String name) {
        System.out.println("Модель " + getClass().getSimpleName() + ": " + name);
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " взлетел в воздух.");
    }

    @Override
    public void countPassengers(int count) {
        System.out.println("Количество пассажиров в " + getClass().getSimpleName() + ": " + count);
    }
}
