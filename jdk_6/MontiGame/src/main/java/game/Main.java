package game;

public class Main {
    public static void main(String[] args) {
        MontiGame game = new MontiGame();

        for (int i = 0; i < 1000; i++) {
            game.startGame();
            game.playerFirstMove();
            game.montiOpenDoor();
            game.playerChangesChoice();
            game.logResult();
        }

        game.showStatistic();

    }
}
