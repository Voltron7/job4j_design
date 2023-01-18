package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MallParkingTest {

    @Test
    public void whenAddTruckAndCarIsSuccessful() {
        MallParking mallParking = new MallParking(2, 1);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle car = new Car("Car");
        mallParking.add(truck);
        mallParking.add(car);
        assertThat(mallParking.getTrucks()).isEqualTo(List.of(truck));
        assertThat(mallParking.getCars()).isEqualTo(List.of(car));
    }

    @Test
    public void whenAddTwoTrucksIsSuccessful() {
        MallParking mallParking = new MallParking(5, 1);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle truck1 = new Truck("Truck1", 3);
        mallParking.add(truck);
        mallParking.add(truck1);
        assertThat(mallParking.getTrucks()).isEqualTo(List.of(truck, truck1));
    }

    @Test
    public void whenAddTwoCarsIsSuccessful() {
        MallParking mallParking = new MallParking(1, 2);
        Vehicle car = new Car("Car");
        Vehicle car1 = new Car("Car1");
        mallParking.add(car);
        mallParking.add(car1);
        assertThat(mallParking.getCars()).isEqualTo(List.of(car, car1));
    }

    @Test
    public void whenAddTrucksAndCarsIsSuccessful() {
        MallParking mallParking = new MallParking(5, 8);
        Vehicle truck = new Truck("Truck", 3);
        Vehicle truck1 = new Truck("Truck1", 2);
        Vehicle truck2 = new Truck("Truck2", 4);
        Vehicle truck3 = new Truck("Truck3", 2);
        Vehicle car = new Car("Car");
        Vehicle car1 = new Car("Car1");
        mallParking.add(truck);
        mallParking.add(truck1);
        mallParking.add(car);
        mallParking.add(truck2);
        mallParking.add(truck3);
        mallParking.add(car1);
        assertThat(mallParking.getTrucks()).isEqualTo(List.of(truck, truck1));
        assertThat(mallParking.getCars()).isEqualTo(List.of(car, truck2, truck3, car1));
    }

    @Test
    public void whenTruckSizeIsInvalid() {
        assertThatThrownBy(() -> new Truck("Truck", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}