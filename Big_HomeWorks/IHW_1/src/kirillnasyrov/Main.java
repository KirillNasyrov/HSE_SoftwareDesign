package kirillnasyrov;

import kirillnasyrov.handlers.GameHandler;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GameHandler.chooseMode(game);
        GameHandler.startGame(game);
    }
}
