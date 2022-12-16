package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMax(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMax(value, comparator.reversed());
    }

    public <T> T findMax(List<T> value, Comparator<T> comparator) {
        if (value.isEmpty()) {
            return null;
        }
        T rsl = value.get(0);
        for (T v : value) {
            rsl = comparator.compare(v, rsl) > 0 ? v : rsl;
        }
        return rsl;
    }
}
