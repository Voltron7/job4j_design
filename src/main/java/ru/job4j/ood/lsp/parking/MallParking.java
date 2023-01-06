package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class MallParking implements Parking {
    private int trucksParkingCapacity;
    private int carsParkingCapacity;
    private final List<Vehicle> cars = new ArrayList<>();
    private final List<Vehicle> trucks = new ArrayList<>();

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Vehicle> getTrucks() {
        return null;
    }

    @Override
    public List<Vehicle> getCars() {
        return null;
    }
}
