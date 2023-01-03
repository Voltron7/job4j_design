package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateExpirationCalculator implements ExpirationCalculator<LocalDate> {

    @Override
    public double calculateInPercent(LocalDate startDate, LocalDate endDate) {
        double elapsedTerm = ChronoUnit.DAYS.between(startDate, LocalDate.now());
        double fullTerm = ChronoUnit.DAYS.between(startDate, endDate);
        if (elapsedTerm < 1 || fullTerm <= 1) {
            throw new IllegalArgumentException("Create date can't be the same or more as expiration date!");
        }
        return (int) (elapsedTerm / fullTerm * 100);
    }
}
