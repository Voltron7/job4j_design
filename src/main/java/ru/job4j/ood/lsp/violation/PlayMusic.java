package ru.job4j.ood.lsp.violation;

public class PlayMusic {
    private final double paid;

    public PlayMusic(double paid) {
        this.paid = paid;
    }

    public String play(String song) {
        if (song.isEmpty()) {
            throw new IllegalArgumentException("Song doesn't exist");
        }
        if (paid < 7) {
            throw new IllegalArgumentException("Not enough money!");
        }
        return "La-la-la";
    }

    class JukeBox extends PlayMusic {

        public JukeBox(double paid) {
            super(paid);
        }

        /*
        Нарушение LSP, так как предусловие (Preconditions),
        проверяющее корректность аргументов конструктора
        или метода, усилено в подклассе .
        */
        public String play(String song) {
            if (song.isEmpty()) {
                throw new IllegalArgumentException("Song doesn't exist");
            }
            if (paid < 77) {
                throw new IllegalArgumentException("Not enough money!");
            }
            return "La-la-la";
        }
    }
}
