package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new FileOutputStream(target))) {
            in.lines()
                    .map(line -> line.split(" "))
                    .filter(line -> "200".equals(line[0]) && !builder.isEmpty()
                            || "300".equals(line[0]) && !builder.isEmpty()
                            || "500".equals(line[0]) && builder.isEmpty()
                            || "400".equals(line[0]) && builder.isEmpty())
                    .forEach(line -> {
                        if ("500".equals(line[0]) || "400".equals(line[0])) {
                            builder.append(line[1])
                            .append(";");
                        } else {
                            builder.append(line[1])
                            .append(";");
                            out.println(builder);
                            builder.delete(0, 18);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "unavailable.csv";
        String target = "target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
    }
}
