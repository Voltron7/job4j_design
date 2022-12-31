package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    protected final Store shop = new Shop();
    protected final Store trash = new Trash();
    protected final Store warehouse = new Warehouse();

    public void distribute(Food food) {
        shop.add(food);
        warehouse.add(food);
        trash.add(food);
    }

    public static int getPercentageOfExpiration(Food food) {
        double elapsedTerm = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double fullTerm = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        if (elapsedTerm < 1 || fullTerm <= 1) {
            throw new IllegalArgumentException("Create date can't be the same or more as expiration date!");
        }
        return (int) (elapsedTerm / fullTerm * 100);
    }
}
