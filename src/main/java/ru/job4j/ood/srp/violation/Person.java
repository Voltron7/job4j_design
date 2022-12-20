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

    public Person createPerson() {
        LocalDateTime created = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = created.format(formatter);
        return new Person("Valeri", "Shpakowski", createdFormat);
    }

    public String createInfo(Person person) {
        return person.name + " " + person.surname + " " + person.created;
    }

    @Override
    public String speak() {
        return "Hello";
    }

    @Override
    public void print(String phrase) {
        System.out.println(phrase);
    }
}
