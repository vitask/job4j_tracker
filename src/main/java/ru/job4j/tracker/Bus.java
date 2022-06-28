package ru.job4j.tracker;

public class Bus implements Transport {

    private static final double PRICE_FUEL = 51.03;

    @Override
    public void run() {
        System.out.println("Передаем за проезд, сейчас поедем.");
    }

    @Override
    public void passenger(int passenger) {
        if (passenger >= 15) {
            System.out.println("Двери закрываются.");
            run();
        } else {
            System.out.println("Ещё ждем.");
        }
    }

    @Override
    public double fuel(double fuel) {
        System.out.println("В автобусе " + fuel + " литров топлива.");
        double price = fuel * PRICE_FUEL;
        System.out.println("Цена заправки на " + fuel + " литров топлива = " + price);
        return price;
    }
}
