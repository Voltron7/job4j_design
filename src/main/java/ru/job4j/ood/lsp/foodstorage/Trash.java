package ru.job4j.ood.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    private final List<Food> trash = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (check(food)) {
            trash.add(food);
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(trash);
    }

    @Override
    public boolean check(Food food) {
        return ControlQuality.getPercentageOfExpiration(food) > 100;
    }
}
