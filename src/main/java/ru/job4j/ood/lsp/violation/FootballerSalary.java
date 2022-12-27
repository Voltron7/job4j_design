package ru.job4j.ood.lsp.violation;

public class FootballerSalary {
    protected int normOfGames;
    protected int payPerGame;
    protected int gamesInSeason = 38;
    protected int missedGames = 33;

    public FootballerSalary(int normOfGames, int payPerGame) {
        this.normOfGames = normOfGames;
        this.payPerGame = payPerGame;
    }

    public int salary(int gamesInSeason, int missedGames) {
        int factGames = 0;
        factGames = gamesInSeason - missedGames;
        if (factGames < normOfGames) {
            throw new IllegalArgumentException("Footballer didn't play enough!");
        }
        return factGames * payPerGame;
    }

    public class StrikerSalary extends FootballerSalary {

        public StrikerSalary(int normOfGames, int payPerGame) {
            super(normOfGames, payPerGame);
        }

        /*
        Нарушение LSP, так как постусловие (Postconditions),
        налагаемое на возвращаемое значение метода,
        не может быть ослаблено в подклассе.
        */
        @Override
        public int salary(int gamesInSeason, int missedGames) {
            int factGames = 0;
            factGames = gamesInSeason - missedGames;
            return factGames * payPerGame;
        }
    }
}
