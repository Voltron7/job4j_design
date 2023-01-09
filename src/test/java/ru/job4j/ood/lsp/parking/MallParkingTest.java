package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@Disabled
class MallParkingTest {

    @Test
    public void whenAddTruckAndCarIsSuccessful() {
        MallParking mallParking = new MallParking(1, 1);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle car = new Car("Car");
        mallParking.add(truck);
        mallParking.add(car);
        assertThat(mallParking.getTrucks().get(0)).isEqualTo(truck);
        assertThat(mallParking.getCars().get(0)).isEqualTo(car);
    }

    @Test
    public void whenAddTrucksAndCarIsSuccessful() {
        MallParking mallParking = new MallParking(1, 3);
        Vehicle truck = new Truck("Truck", 3);
        Vehicle truck1 = new Truck("Truck1", 2);
        Vehicle car = new Car("Car");
        mallParking.add(truck);
        mallParking.add(car);
        mallParking.add(truck1);
        assertThat(mallParking.getTrucks().get(0)).isEqualTo(truck);
        assertThat(mallParking.getCars().get(1)).isEqualTo(car);
        assertThat(mallParking.getCars().get(0)).isEqualTo(truck1);
    }

    @Test
    public void whenAddTrucksIsInvalid() {
        MallParking mallParking = new MallParking(1, 2);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle truck1 = new Truck("Truck", 3);
        mallParking.add(truck);
        mallParking.add(truck1);
        assertThat(mallParking.getTrucks().get(0)).isEqualTo(truck);
        assertThat(mallParking.getCars().get(0)).isNotEqualTo(truck1);
    }

    @Test
    public void whenAddCarsIsInvalid() {
        MallParking mallParking = new MallParking(1, 1);
        Vehicle car = new Car("Car");
        Vehicle car1 = new Car("Car1");
        mallParking.add(car);
        mallParking.add(car1);
        assertThat(mallParking.getCars().get(0)).isEqualTo(car);
        assertThat(mallParking.getCars().get(1)).isNotEqualTo(car1);
    }

    @Test
    public void whenTruckSizeIsInvalid() {
        assertThatThrownBy(() -> new Truck("Truck", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}