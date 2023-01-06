package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    Store trash = new Trash(new LocalDateExpirationCalculator());
    Store warehouse = new Warehouse(new LocalDateExpirationCalculator());
    Store shop = new Shop(new LocalDateExpirationCalculator());
    List<Store> storesList = new ArrayList<>(List.of(trash, warehouse, shop));
    ControlQuality cq = new ControlQuality(storesList);

    @Test
    public void whenDistributeToStores() {
        Food bread = new Bread("Bread", LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(6),
                70.00f, 50.0f);
        Food cheese = new Cheese("Cheese", LocalDate.now().plusMonths(5), LocalDate.now().minusMonths(1),
                500.00f, 50.0f);
        Food butter = new Butter("Butter", LocalDate.now().plusMonths(3), LocalDate.now().minusMonths(3),
                150.00f, 20.0f);
        cq.distribute(bread);
        cq.distribute(cheese);
        cq.distribute(butter);
        assertThat(trash.getAll().get(0)).isEqualTo(bread);
        assertThat(warehouse.getAll().get(0)).isEqualTo(cheese);
        assertThat(shop.getAll().get(0)).isEqualTo(butter);
    }

    @Test
    public void whenTrash() {
        Food bread = new Bread("Bread", LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(6),
                70.00f, 50.0f);
        cq.distribute(bread);
        assertThat(trash.getAll().get(0)).isEqualTo(bread);
    }

    @Test
    public void whenWarehouse() {
        Food cheese = new Cheese("Cheese", LocalDate.now().plusMonths(5), LocalDate.now().minusMonths(1),
                500.00f, 50.0f);
        cq.distribute(cheese);
        assertThat(warehouse.getAll().get(0)).isEqualTo(cheese);
    }

    @Test
    public void whenShopWithDiscount() {
        Food butter1 = new Butter("Butter1", LocalDate.now().plusMonths(1), LocalDate.now().minusMonths(9),
                150.00f, 20.0f);
        cq.distribute(butter1);
        assertThat(shop.getAll().get(0).getPrice()).isEqualTo(butter1.getPrice());
    }

    @Test
    public void whenShopWithoutDiscount() {
        Food butter = new Butter("Butter", LocalDate.now().plusMonths(3), LocalDate.now().minusMonths(3),
                150.00f, 20.0f);
        cq.distribute(butter);
        assertThat(shop.getAll().get(0).getPrice()).isEqualTo(butter.getPrice());
    }
}