package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        String[] strings = validation(args);
        Path start = Paths.get(strings[0]);
        search(start, p -> p.toFile().getName().endsWith(strings[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static String[] validation(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage ROOT_FOLDER.");
        }
        if (!args[1].startsWith(".csv")) {
            throw new IllegalArgumentException("The file must starts with \".csv\"");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exists %s", start.toFile().getAbsoluteFile()));
        }
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toFile().getAbsoluteFile()));
        }
        return args;
    }
}
