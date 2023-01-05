package ru.job4j.ood.lsp.parking;

public class MallParking extends AbstractParking {

    @Override
    protected boolean checkCars(Vehicle vehicle) {
        return false;
    }

    @Override
    protected boolean checkTrucks(Vehicle vehicle) {
        return false;
    }
}
