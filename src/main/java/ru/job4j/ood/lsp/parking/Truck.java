package ru.job4j.ood.lsp.parking;

public class Truck extends Vehicle {

    public Truck(String name, int size) {
        super(name, size);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public void setSize(int size) {
        super.setSize(size);
    }
}
