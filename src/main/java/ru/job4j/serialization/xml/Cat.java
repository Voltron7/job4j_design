package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Cat {
    private final String name;
    private final boolean isSterilized;
    private final int age;
    private final Contact contact;
    private final String[] infos;

    public Cat(String name, boolean isSterilized, int age, Contact contact, String[] infos) {
        this.name = name;
        this.isSterilized = isSterilized;
        this.age = age;
        this.contact = contact;
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", isSterilized=" + isSterilized
                + ", age=" + age
                + ", contact=" + contact
                + ", infos=" + Arrays.toString(infos)
                + '}';
    }
}
