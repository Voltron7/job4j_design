package ru.job4j.ood.lsp.foodstorage;

import java.util.List;

public class ControlQuality {
    List<Store> storesList;

    public ControlQuality(List<Store> storesList) {
        this.storesList = storesList;
    }

    public void distribute(Food food) {
        for (Store store : storesList) {
            if (store.add(food)) {
            break;
            }
        }
    }
}
