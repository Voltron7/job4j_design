package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;

public class Butter extends Food {
    public Butter(String name, LocalDate expiryDate, LocalDate createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDate expiryDate) {
        super.setExpiryDate(expiryDate);
    }

    @Override
    public LocalDate getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(LocalDate createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public float getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }

    @Override
    public float getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(float discount) {
        super.setDiscount(discount);
    }
}
