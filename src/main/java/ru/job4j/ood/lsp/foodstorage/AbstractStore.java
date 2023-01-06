package ru.job4j.ood.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (!isFresh(food)) {
            return false;
        }
        foods.add(food);
        return true;
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foods);
    }

    protected abstract boolean isFresh(Food food);
}
