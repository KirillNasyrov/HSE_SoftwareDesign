package kirillnasyrov.models.player;

import kirillnasyrov.Game;
import kirillnasyrov.GameMode;
import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Color;

public class Computer extends Player {
    private GameMode gameMode;

    public Computer(Color color, GameMode gameMode) {
        super(color);
        this.gameMode = gameMode;
    }

    @Override
    public Cell chooseTheCell(Game game) {
        if (gameMode == GameMode.Easy) {
            return chooseTheCellAtEasyMode(game);
        } else {
            return null;
        }
    }

    public Cell chooseTheCellAtEasyMode(Game game) {
        String message = "Ходит компьютер, у которого белые фишки.";
        System.out.println(message);
        if (GameHandler.getNumberOfUsableCellsForPlayer(game, this) == 0) {
            System.out.println("Компьютер не может сходить.");
            possibilityToMove = !possibilityToMove;
            return null;
        }
        double max = 0;
        Cell cellShouldBeChosen = null;
        for (int number = 1; number <= 8; ++number) {
            for (char letter = 'a'; letter <= 'h'; ++letter) {
                if (game.getGameBoard().getField().getCell(number, letter).canBeChosen()) {
                    if (GameHandler.changeColorOfCells(game, this, game.getGameBoard().getField().getCell(number, letter), true) > max) {
                        max = GameHandler.changeColorOfCells(game, this, game.getGameBoard().getField().getCell(number, letter), true);
                        cellShouldBeChosen = game.getGameBoard().getField().getCell(number, letter);
                    }
                }
            }
        }
        possibilityToMove = !possibilityToMove;
        return cellShouldBeChosen;
    }
}