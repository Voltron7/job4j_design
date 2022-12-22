package ru.job4j.ood.ocp.violation;

public class Worker {

    /*
    Нарушение OCP, так как в класс Developer добавлен метод review,
    то есть класс Developer изменен. А сущности должны быть открыты к расширению,
     но закрыты к изменению.
     */
    private static class Developer {

        public String code() {
            return "Coding";
        }

        public String review() {
            return "Reviewing";
        }
    }

}
