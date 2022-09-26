package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        List<String> filteredList = List.of(argsName.get("filter").split(","));
        List<Integer> indexes = new ArrayList<>();
        try (var scanner = new Scanner(Paths.get(argsName.get("path")))) {
            String[] headerArray = scanner.nextLine().split(argsName.get("delimiter"));
            for (int i = 0; i < headerArray.length; i++) {
                if (filteredList.contains(headerArray[i])) {
                    indexes.add(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(argsName.get("out")));
                Scanner scanner = new Scanner(Paths.get(argsName.get("path")))) {
            while (scanner.hasNextLine()) {
                StringBuilder builder = new StringBuilder();
                String[] lines = scanner.nextLine().split(argsName.get("delimiter"));
                for (Integer index : indexes) {
                    builder.append(lines[index]).append(";");
                }
                builder.setLength(builder.length() - 1);
                out.println(builder);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void csvValidation(ArgsName argsName) {
        if (!Paths.get(argsName.get("path")).toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Delimiter should be \";\"");
        }
        if (argsName.get("out").isEmpty()) {
            throw new IllegalArgumentException("Out should be \"stdout\"");
        }
        if (argsName.get("filter").isBlank()) {
            throw new IllegalArgumentException("Filter doesn't exist");
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null.");
        }
        csvValidation(ArgsName.of(args));
        handle(ArgsName.of(args));
    }
}
