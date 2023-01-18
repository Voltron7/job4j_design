package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class MallParking implements Parking {
    private static final int ONE_TRUCK_PARKING_SPACE = 1;
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
        if (vehicle.getSize() > 1
                && trucksParkingCapacity >= ONE_TRUCK_PARKING_SPACE) {
            trucks.add(vehicle);
            trucksParkingCapacity -= ONE_TRUCK_PARKING_SPACE;
        } else if (carsParkingCapacity >= vehicle.getSize()) {
            cars.add(vehicle);
            carsParkingCapacity -= vehicle.getSize();
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
