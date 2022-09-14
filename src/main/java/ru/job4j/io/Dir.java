package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("File's size is: %s%n", file.getTotalSpace());
        for (File subFile : file.listFiles()) {
            System.out.printf("File's name is : %s, file's length is: %s%n", subFile.getName(), subFile.length());
        }
    }
}
