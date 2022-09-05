package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void whenNumberOfVerticesOfSphere() {
        Box box = new Box(0, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(0).isNotNegative();
    }

    @Test
    void whenNumberOfVerticesOfTetrahedron() {
        Box box = new Box(4, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(4).isEven();
    }

    @Test
    void whenNumberOfVerticesOfCube() {
        Box box = new Box(8, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(8).isEven();
    }

    @Test
    void isExistTrue() {
        Box box = new Box(8, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(8, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }


    @Test
    void getAreaOfSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.6370614359173).isLessThan(1257).isGreaterThan(1256);
    }

    @Test
    void getAreaOfTetrahedron() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(173.20508075688773).isLessThan(174).isGreaterThan(173);
    }

    @Test
    void getAreaOfCube() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(600).isNotNegative().isGreaterThan(500);
    }
}