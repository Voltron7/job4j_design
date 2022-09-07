package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            String result;
            for (int multiplier = 1; multiplier <= 10; multiplier++) {
                out.write(System.lineSeparator().getBytes());
                for (int multiplicand = 1; multiplicand <= 10; multiplicand++) {
                    result = multiplier + "*" + multiplicand + "=" + (multiplier * multiplicand) + "\t";
                    out.write(result.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
