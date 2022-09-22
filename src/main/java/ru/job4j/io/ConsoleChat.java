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
        String expression;
        System.out.println("You are in ConsoleChat! Commands: pause, continue, exit.");
        System.out.print("Ask your question or write a command: ");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            expression = reader.readLine();
            saveLog(expression);
            switch (expression) {
                case STOP:
                    System.out.println("You have to write a command \"continue\" to get an answer");
                    System.out.println("or you may go on to ask questions without an answers or just to exit");
                    expression = reader.readLine();
                    saveLog(expression);
                case CONTINUE:
                    run();
                    break;
                case OUT:
                    System.exit(0);
                    break;
                default:
                    String answer = readPhrases()
                        .get((int) (Math.random() * readPhrases().size()));
                    System.out.println("Answer is " + answer);
                    saveLog(answer);
                    run();
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
