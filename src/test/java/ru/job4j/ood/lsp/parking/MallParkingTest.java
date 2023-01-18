package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@Disabled
class MallParkingTest {

    @Test
    public void whenAddTruckAndCarIsSuccessful() {
        MallParking mallParking = new MallParking(1, 1);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle car = new Car("Car");
        assertThat(mallParking.add(truck)).isTrue();
        assertThat(mallParking.add(car)).isTrue();
    }

    @Test
    public void whenAddTrucksAndCarIsSuccessful() {
        MallParking mallParking = new MallParking(1, 3);
        Vehicle truck = new Truck("Truck", 3);
        Vehicle truck1 = new Truck("Truck1", 2);
        Vehicle car = new Car("Car");
        mallParking.add(truck);
        mallParking.add(truck1);
        mallParking.add(car);
        assertThat(mallParking.getTrucks()).isEqualTo(List.of(truck));
        assertThat(mallParking.getCars()).isEqualTo(List.of(truck1, car));
    }

    @Test
    public void whenAddTrucksIsInvalid() {
        MallParking mallParking = new MallParking(1, 2);
        Vehicle truck = new Truck("Truck", 2);
        Vehicle truck1 = new Truck("Truck", 3);
        assertThat(mallParking.add(truck)).isTrue();
        assertThat(mallParking.add(truck1)).isFalse();
    }
    @Test
    public void whenAddCarsIsInvalid() {
        MallParking mallParking = new MallParking(1, 1);
        Vehicle car = new Car("Car");
        Vehicle car1 = new Car("Car1");
        assertThat(mallParking.add(car)).isTrue();
        assertThat(mallParking.add(car1)).isFalse();
    }

    @Test
    public void whenTruckSizeIsInvalid() {
        assertThatThrownBy(() -> new Truck("Truck", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}