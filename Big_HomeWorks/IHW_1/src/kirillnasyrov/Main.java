package kirillnasyrov;

import kirillnasyrov.game.Game;
import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.consoleworker.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        int choice;
        do {
            Game game = new Game();
            GameHandler.chooseMode(game);
            GameHandler.startGame(game);
            choice = ConsoleReader.getNumberOfChoice();
        } while (choice == 1);
    }
}
