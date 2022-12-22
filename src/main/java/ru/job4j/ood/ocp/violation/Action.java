package ru.job4j.ood.ocp.violation;

public class Action {

    public interface ActionType {
    }

    public class Learning implements ActionType {
        private String language;

        public Learning(String language) {
            this.language = language;
        }
    }

    /*
    Нарушение OCP, так как классы должны зависеть от абстракций, а не от реализаций,
    а подобный подход как в примере мешает наследованию.
     */
    public class ActionExecutor  {

        public void execute(Learning learn) {
            System.out.println("Learning programming language");
        }
    }
}
