package ru.job4j.ood.lsp.foodstorage;

public interface ExpirationCalculator<T> {

    double calculateInPercent(T startDate, T endDate);
}
