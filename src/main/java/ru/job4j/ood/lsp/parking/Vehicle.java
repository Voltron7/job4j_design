package ru.job4j.ood.lsp.parking;

public abstract class Vehicle {
    private String name;
    private final int size;

    public Vehicle(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Vehicle{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
