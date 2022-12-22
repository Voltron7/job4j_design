package ru.job4j.ood.ocp.violation;

import java.util.List;

public class CarsImplementation {

    /*
    А если будет требование заправить авто не с электродвигателем, а с ДВС?
    Здесь наследование использовать нельзя, так как при наследовании, наследуется
    состояние объекта предка. Авто с электродвигателем не может иметь те же
    характеристики, что и авто с ДВС, но оба авто могут быть заправлены электричеством
    и топливом соответственно. Код спроектирован изначально неверно - нарушение OCP.
    */
    private static class ElectricCar {

        public String fill() {
            return "The сar is filled.";
        }
    }

    public static void main(String[] args) {
        List<ElectricCar> rectangles = List.of(new ElectricCar());
        rectangles.forEach(ElectricCar::fill);
    }
}
