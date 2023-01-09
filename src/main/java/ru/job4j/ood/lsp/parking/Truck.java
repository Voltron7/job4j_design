package ru.job4j.ood.lsp.parking;

public class Truck extends Vehicle {

    public Truck(String name, int size) {
        super(name, size);
        if (size <= Car.SIZE) {
            throw new IllegalArgumentException("Truck size must be more than 1");
        }
    }
}
