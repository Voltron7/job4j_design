package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.path))) {
            in.lines()
                    .filter(line -> !line.isBlank() && !line.startsWith("#"))
                    .filter(line -> {
                        if (!line.contains("=") || line.startsWith("=")
                                || line.indexOf("=") == line.length() - 1) {
                            throw new IllegalArgumentException("Incorrect properties input.");
                        }
                        return true;
                    })
                    .map(line -> line.split("=", 2))
                    .forEach(k -> values.put(k[0], k[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
        Config config = new Config("app.properties");
        config.load();
        for (String val : config.values.keySet()) {
            System.out.println("Key: " + val + " , Value: " + config.values.get(val));
        }
    }
}
