package ru.job4j.serialization.json;

import java.util.Arrays;

public class Person2 {
    private final String name;
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] skills;


    public Person2(String name, boolean sex, int age, Contact contact, String[] skills) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Person2{"
                + "name=" + name
                + ", sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", skills=" + Arrays.toString(skills)
                + '}';
    }
}
