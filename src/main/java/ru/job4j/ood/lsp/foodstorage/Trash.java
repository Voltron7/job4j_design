package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;
import static ru.job4j.ood.lsp.foodstorage.Shop.TRASH;

public class Trash extends AbstractStore {
    private final ExpirationCalculator<LocalDate> expirationCalculator;

    public Trash(ExpirationCalculator<LocalDate> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean check(Food food) {
        return expirationCalculator.calculateInPercent(
                food.getCreateDate(), food.getExpiryDate()) >= TRASH;
    }
}
