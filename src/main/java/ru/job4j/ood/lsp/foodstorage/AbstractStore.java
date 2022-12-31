package ru.job4j.ood.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        foods.add(food);
        return true;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(foods);
    }

    public abstract boolean check(Food food);
}
