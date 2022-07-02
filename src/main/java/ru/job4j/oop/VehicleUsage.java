package ru.job4j.oop;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = {bus, train, airplane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
        bus.nameVehicle("ПАЗ - 3205");
        bus.countPassengers(24);
        train.nameVehicle("Воркута");
        train.countPassengers(349);
        airplane.nameVehicle("Боинг - 777");
        airplane.countPassengers(230);
    }
}
