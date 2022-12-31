package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    ControlQuality cq = new ControlQuality();

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
        assertThat(cq.trash.get().get(0)).isEqualTo(bread);
        assertThat(cq.warehouse.get().get(0)).isEqualTo(cheese);
        assertThat(cq.shop.get().get(0)).isEqualTo(butter);
    }

    @Test
    public void whenTrash() {
        Food bread = new Bread("Bread", LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(6),
                70.00f, 50.0f);
        cq.distribute(bread);
        assertThat(bread).isEqualTo(cq.trash.get().get(0));
    }

    @Test
    public void whenWarehouse() {
        Food cheese = new Cheese("Cheese", LocalDate.now().plusMonths(5), LocalDate.now().minusMonths(1),
                500.00f, 50.0f);
        cq.distribute(cheese);
        assertThat(cheese).isEqualTo(cq.warehouse.get().get(0));
    }

    @Test
    public void whenShopWithDiscount() {
        Food butter1 = new Butter("Butter1", LocalDate.now().plusMonths(1), LocalDate.now().minusMonths(9),
                150.00f, 20.0f);
        cq.distribute(butter1);
        assertThat(butter1.getPrice()).isEqualTo(cq.shop.get().get(0).getPrice());
    }

    @Test
    public void whenShopWithoutDiscount() {
        Food butter = new Butter("Butter", LocalDate.now().plusMonths(3), LocalDate.now().minusMonths(3),
                150.00f, 20.0f);
        cq.distribute(butter);
        assertThat(butter.getPrice()).isEqualTo(cq.shop.get().get(0).getPrice());
    }
}