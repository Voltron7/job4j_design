package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {

    private static final double FRESHNESS_LIMIT = 25;

    private final ExpirationCalculator<LocalDate> expirationCalculator;

    public Warehouse(ExpirationCalculator<LocalDate> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isFresh(Food food) {
        return expirationCalculator.calculateInPercent(
                food.getCreateDate(), food.getExpiryDate()) < FRESHNESS_LIMIT;
    }
}
