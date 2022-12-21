package ru.job4j.ood.srp.violation;

/*
Нарушение SRP из-за того, что некорректно выделена абстракция.
Каждая абстракция должна отвечать только за представление
своего функционала.
 */
public interface People {
    String speak();

    void print(String phrase);
}
