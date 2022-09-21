package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("The array of args is empty.");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .filter(line -> {
                    argsValidation(line);
                    return true;
                })
                .map(line -> line.split("=", 2))
                .forEach(strings -> values.put(strings[0].substring(1), strings[1]));
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("The array of args is empty");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void argsValidation(String args) {
        if (!args.startsWith("-")) {
            throw new IllegalArgumentException("The string does not start with \"-\"");
        }
        if (args.startsWith("-=")) {
            throw new IllegalArgumentException("The key does not exist");
        }
        if (!args.contains("=")) {
            throw new IllegalArgumentException("The equal symbol does not exist");
        }
        if (args.indexOf("=") == args.length() - 1) {
            throw new IllegalArgumentException("The value does not exist");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
