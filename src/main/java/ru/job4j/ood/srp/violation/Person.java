package ru.job4j.ood.srp.violation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person implements People {
    private String name;
    private String surname;
    private String created;

    public Person(String name, String surname, String created) {
        this.name = name;
        this.surname = surname;
        this.created = created;
    }

    /*
    Нарушение SRP из-за того, что класс умеет создавать и инициализировать объект.
    Нарушение SRP из-за того, что, например, используется дата в определенном формате,
    который может поменяться.
     */
    public Person createPerson() {
        LocalDateTime created = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = created.format(formatter);
        return new Person("Valeri", "Shpakowski", createdFormat);
    }

    /*
    Нарушение SRP из-за того, что большое количество публичных методов класса.
     */
    public String createInfo(Person person) {
        return person.name + " " + person.surname + " " + person.created;
    }

    /*
    Нарушение SRP из-за того, что у класса несколько целей, а должна быть одна.
    Например, Цель метода speak возвращать "Hello", а метода print выводить любую
    строку в консоль.
     */
    @Override
    public String speak() {
        return "Hello";
    }

    @Override
    public void print(String phrase) {
        System.out.println(phrase);
    }
}
