package ru.job4j.ood.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    private final List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (check(food)) {
            warehouse.add(food);
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(warehouse);
    }

    @Override
    public boolean check(Food food) {
        return ControlQuality.getPercentageOfExpiration(food) < 25;
    }
}
