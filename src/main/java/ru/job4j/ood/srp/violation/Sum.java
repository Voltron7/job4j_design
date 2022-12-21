package ru.job4j.ood.srp.violation;

import java.util.List;

/*
Нарушение SRP из-за того, что некорректно выделена абстракция.
Каждая абстракция должна отвечать только за представление
своего функционала.
 */
public interface Sum {

    int sum(List<Integer> list);

    void print(int number);
}
