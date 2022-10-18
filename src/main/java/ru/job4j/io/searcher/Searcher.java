package ru.job4j.io.searcher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Searcher {
    public static Predicate<Path> searchMask(ArgsName argsName) {
        Predicate<Path> name = path -> path.toFile().getName()
                .endsWith(argsName.get("n"));
        Predicate<Path> mask = path -> path.toFile().getName()
                .matches(argsName.get("n").replace(".", "[.]")
                        .replace("*", ".+")
                        .replace("?", "."));
        Predicate<Path> regex = path -> path.toFile().getName()
                .matches(argsName.get("n"));
        return argsName.get("t").equals("name") ? name : argsName.get("t").equals("regex") ? regex : mask;
    }

    private void saveLog(List<Path> log, ArgsName argsName) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(argsName.get("o"))))) {
            log.forEach(out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validate(ArgsName argsName) {
        if (argsName.get("n").isEmpty()) {
            throw new IllegalArgumentException("The pattern is empty");
        }
        if (!(argsName.get("t").equals("name") || argsName.get("t").equals("mask")
                || argsName.get("t").equals("regex"))) {
            throw new IllegalArgumentException("The type of pattern is invalid");
        }
        if (argsName.get("o").isEmpty()) {
            throw new IllegalArgumentException("The save file is empty");
        }
        if (!Paths.get(argsName.get("d")).toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!Paths.get(argsName.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("The directory does not exist");
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Argument is null");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        Path start = Paths.get(argsName.get("d"));
        Searcher searcher = new Searcher();
        searcher.saveLog(search(start, searchMask(argsName)), argsName);
    }
}
