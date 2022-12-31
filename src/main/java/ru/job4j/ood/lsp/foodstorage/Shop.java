package ru.job4j.ood.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    private final List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (check(food)) {
            shop.add(food);
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(shop);
    }

    @Override
    public boolean check(Food food) {
        int percentage = ControlQuality.getPercentageOfExpiration(food);
        if (percentage > 75 && percentage < 100) {
            food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
            return true;
        }
        return percentage >= 25 && percentage <= 75;
    }
}
