package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;

public class Shop extends AbstractStore {

    private static final double DISCOUNT_THRESHOLD = 75;

    private static final double FRESHNESS_UPPER_LIMIT = 100;

    private static final double FRESHNESS_LOWER_LIMIT = 25;

    private final ExpirationCalculator<LocalDate> expirationCalculator;

    public Shop(ExpirationCalculator<LocalDate> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isFresh(Food food) {
        double percentage = expirationCalculator.calculateInPercent(
                food.getCreateDate(), food.getExpiryDate());
        if (percentage > DISCOUNT_THRESHOLD && percentage < FRESHNESS_UPPER_LIMIT) {
            setDiscount(food);
            return true;
        }
        return percentage >= FRESHNESS_LOWER_LIMIT && percentage <= DISCOUNT_THRESHOLD;
    }

    private void setDiscount(Food food) {
        food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
    }
}
