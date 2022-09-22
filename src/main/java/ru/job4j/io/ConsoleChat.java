package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private static final String OUT = "exit";
    private static final String STOP = "pause";
    private static final String CONTINUE = "continue";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> temp = readPhrases();
        String expression = "";
        System.out.println("You are in ConsoleChat! Commands: pause, continue, exit.");
        System.out.print("Ask your question or write a command: ");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            while (!OUT.equals(expression)) {
            expression = reader.readLine();
            saveLog(expression);
            switch (expression) {
                case OUT:
                    System.exit(0);
                    break;
                case STOP:
                    System.out.println("You have to write a command \"continue\" to get an answer");
                    System.out.println("or you may go on to ask questions without an answers or just to exit");
                    do {
                        expression = reader.readLine();
                        saveLog(expression);
                    } while (!CONTINUE.equals(expression));
                case CONTINUE:
                    System.out.print("Ask your question or write a command again: ");
                    expression = reader.readLine();
                    saveLog(expression);
                default:
                    String answer = temp.get((int) (Math.random() * temp.size()));
                    System.out.println("Answer is " + answer);
                    saveLog(answer);
                    System.out.print("Ask your question or write a command again: ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            br.lines()
                    .forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }
    private void saveLog(String log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            pw.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "./data/logConsoleChat.txt", "./data/answers.txt");
        cc.run();
    }
}
