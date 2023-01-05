package ru.job4j.ood.lsp.parking;

import java.util.List;;

public abstract class AbstractParking implements Parking {

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Vehicle> getCars() {
        return null;
    }

    @Override
    public List<Vehicle> getTrucks() {
        return null;
    }

    protected abstract boolean checkCars(Vehicle vehicle);

    protected abstract boolean checkTrucks(Vehicle vehicle);
}
