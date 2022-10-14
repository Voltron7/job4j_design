package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

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

        /* JSONObject из json-строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"77-777-77\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Developer");
        list.add("FreeSoul");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", person2.getName());
        jsonObject.put("sex", person2.isSex());
        jsonObject.put("age", person2.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person2 в json-строку */
        System.out.println(new JSONObject(person2));
    }
}
