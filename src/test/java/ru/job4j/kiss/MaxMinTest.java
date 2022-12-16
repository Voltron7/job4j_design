package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

class MaxMinTest {
    private Comparator<Integer> comparator;

    @BeforeEach
    void test() {
        comparator = Comparator.naturalOrder();
    }

    @Test
    void whenFindMax() {
        MaxMin max = new MaxMin();
        List<Integer> values = Arrays.asList(7, 5, 6, 3, 4, 1, 2);
        assertThat(max.max(values, comparator)).isEqualTo(7);
    }

    @Test
    void whenFindMin() {
        MaxMin min = new MaxMin();
        List<Integer> values = Arrays.asList(7, 5, 6, 3, 4, 1, 2);
        assertThat(min.min(values, comparator)).isEqualTo(1);
    }

    @Test
    void whenListIsEmpty() {
        MaxMin empty = new MaxMin();
        List<Integer> values = Collections.emptyList();
        assertThat(empty.findMax(values, comparator)).isNull();
    }
}