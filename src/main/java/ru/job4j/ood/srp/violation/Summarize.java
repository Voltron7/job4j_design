package ru.job4j.ood.srp.violation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Summarize implements Sum {

    /*
    Нарушение SRP из-за того, что у класса несколько целей, а должна быть одна.
    Например, Цель метода sum суммировать все числа из списка,
    а метода print выводить число в консоль.
     */
    @Override
    public int sum(List<Integer> integers) {
        int rsl = 0;
        for (Integer integer : integers) {
            rsl += integer;
        }
        return rsl;
    }

    @Override
    public void print(int rsl) {
        System.out.println(rsl);
    }

    /*
    Нарушение SRP из-за того, что, например, используется дата в определенном формате,
    который может поменяться.
     */
    public String info() {
        LocalDateTime created = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        return created.format(formatter);
    }
}
