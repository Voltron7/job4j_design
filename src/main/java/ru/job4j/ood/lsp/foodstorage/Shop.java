package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;

public class Shop extends AbstractStore {
    private final ExpirationCalculator<LocalDate> expirationCalculator;
    public static final double DISCOUNT = 75;
    public static final double WAREHOUSE = 25;
    public static final double TRASH = 100;

    public Shop(ExpirationCalculator<LocalDate> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isFresh(Food food) {
        double percentage = expirationCalculator.calculateInPercent(
                food.getCreateDate(), food.getExpiryDate());
        if (percentage > DISCOUNT && percentage < TRASH) {
            discount(food);
            return true;
        }
        return percentage >= WAREHOUSE && percentage <= DISCOUNT;
    }

    private void discount(Food food) {
        food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
    }
}
