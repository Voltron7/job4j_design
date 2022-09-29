package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] filteredList = argsName.get("filter").split(",");
        int[] indexArray = new int[filteredList.length];
        try (PrintWriter out = new PrintWriter(new FileOutputStream(argsName.get("out")));
                Scanner scanner = new Scanner(Paths.get(argsName.get("path")))) {
            while (scanner.hasNextLine()) {
                StringBuilder builder = new StringBuilder();
                String[] lines = scanner.nextLine().split(argsName.get("delimiter"));
                for (int i = 0; i < filteredList.length; i++) {
                    for (int j = 0; j < lines.length; j++) {
                        if (filteredList[i].equals(lines[j])) {
                            indexArray[i] = j;
                            break;
                        }
                    }
                }
                for (int i = 0; i < indexArray.length; i++) {
                    builder.append(lines[indexArray[i]])
                            .append(i == indexArray.length - 1 ? "" : argsName.get("delimiter"));
                }
                if ("stdout".equals(argsName.get("out"))) {
                    System.out.println(builder);
                } else {
                        out.println(builder);
                }
            }
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
