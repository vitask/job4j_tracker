package ru.job4j.tracker;

public interface Transport {
    void run();

    void passenger(int passenger);

    double fuel(double fuel);
}
