package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@Disabled
class MallParkingTest {

    @Test
    public void whenAddIsSuccessful() {
        MallParking mallParking = new MallParking();
        Vehicle car = new Car("Car", 1);
        Vehicle truck = new Truck("Truck", 2);
        mallParking.add(car);
        mallParking.add(truck);
        assertThat(mallParking.getCars().get(0).getName()).isEqualTo("Car");
        assertThat(mallParking.getTrucks().get(0).getName()).isEqualTo("Truck");
    }

    @Test
    public void whenAddIsInvalid() {
        MallParking mallParking = new MallParking();
        Vehicle car = new Car("Car", 1);
        Vehicle truck = new Truck("Truck", 2);
        mallParking.add(car);
        mallParking.add(truck);
        assertThat(mallParking.getCars().get(0).getName()).isEqualTo("Car");
        assertThat(mallParking.getTrucks().get(0).getName()).isNotEqualTo("Truck");
    }
}