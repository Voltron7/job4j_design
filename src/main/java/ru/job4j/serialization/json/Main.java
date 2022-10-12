package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);

        final Person2 person2 = new Person2("Valeri", true, 39, new Contact("77-777"),
                 new String[] {"Spring, Hibernate"});
        final Gson gson2 = new GsonBuilder().create();
        System.out.println(gson2.toJson(person2));

        final String personJson2 =
                "{"
                        + "\"name\": Pavel,"
                        + "\"sex\":true,"
                        + "\"age\":42,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(911)777-777-77-77\""
                        + "},"
                        + "\"skills\":"
                        + "[\"Python\",\"Django\"]"
                        + "}";
        final Person2 personMod2 = gson2.fromJson(personJson2, Person2.class);
        System.out.println(personMod2);
    }
}
