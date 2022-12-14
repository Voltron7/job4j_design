package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Emulator {
    public static final int LOAD_CACHE = 1;
    public static final int GET_CACHE = 2;

    public static final String SELECT = "Выберите меню";
    public static final String DIR_PATH = "Введите директорию";
    public static final String FILE_NAME = "Введите имя файла с расширением";
    public static final String SHOW_CONTENT = "Введите имя файла для просмотра содержимого из кэша";
    public static final String EXIT = "Конец работы";

    public static final String MENU = """
                Введите 1, чтобы загрузить содержимое файла в кэш.
                Введите 2, чтобы получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(DIR_PATH);
        String dir = scanner.nextLine();
        if (!Files.exists(Paths.get(dir))) {
            throw new IllegalArgumentException(String.format("Directory %s doesn't exist", dir));
        }
        start(scanner, new DirFileCache(dir));
    }

    private static void start(Scanner scanner, DirFileCache dirFileCache) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (LOAD_CACHE == userChoice) {
                System.out.println(FILE_NAME);
                String key = scanner.nextLine();
                if (!Files.exists(Paths.get(String.format("%s", key)))) {
                    throw new IllegalArgumentException(String.format("File %s doesn't exist", key));
                }
                dirFileCache.put(key, dirFileCache.get(key));
                System.out.println("Содержимое файла загружено в кэш успешно.");
            } else if (GET_CACHE == userChoice) {
                System.out.println(SHOW_CONTENT);
                String key = scanner.nextLine();
                System.out.println(dirFileCache.get(key));
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
