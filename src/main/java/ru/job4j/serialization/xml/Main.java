package ru.job4j.serialization.xml;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30,
                new Contact("11-111"), new String[]{"Worker", "Married"});
        System.out.println(person);

        final Cat cat = new Cat("Milo", false, 7,
                new Contact("33-333"), new String[]{"Male, Blooded"});
        System.out.println(cat);
    }
}
