package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class MallParking implements Parking {
    private int trucksParkingCapacity;
    private int carsParkingCapacity;
    private final List<Vehicle> cars;
    private final List<Vehicle> trucks;

    public MallParking(int trucksParkingCapacity, int carsParkingCapacity) {
        this.trucksParkingCapacity = trucksParkingCapacity;
        this.carsParkingCapacity = carsParkingCapacity;
        this.trucks = new ArrayList<>(trucksParkingCapacity);
        this.cars = new ArrayList<>(carsParkingCapacity);
    }

    @Override
    public boolean add(Vehicle vehicle) {
        if (vehicle.getSize() > Car.SIZE
                && trucksParkingCapacity >= Car.SIZE) {
            trucks.add(vehicle);
            trucksParkingCapacity--;
            return true;
        } else if (carsParkingCapacity >= vehicle.getSize()) {
            cars.add(vehicle);
            carsParkingCapacity -= vehicle.getSize();
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> getTrucks() {
        return new ArrayList<>(trucks);
    }

    @Override
    public List<Vehicle> getCars() {
        return new ArrayList<>(cars);
    }
}
