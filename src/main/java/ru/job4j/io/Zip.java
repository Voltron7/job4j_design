package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (Path source : sources) {
            zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArgsName zipValidation(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null.");
        }
        ArgsName argsName = ArgsName.of(args);
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("The file must starts with \".\"");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The file must ends with \".zip\"");
        }
        if (!Path.of(argsName.get("d")).toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!Path.of(argsName.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("The directory does not exist");
        }
        return argsName;
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}