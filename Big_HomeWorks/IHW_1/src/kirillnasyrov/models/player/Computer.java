package kirillnasyrov.models.player;

import kirillnasyrov.game.Game;
import kirillnasyrov.game.GameMode;
import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Chip;
import kirillnasyrov.models.chip.Color;

/**
 * Класс, описывающий компьютер
 */
public class Computer extends Player {
    private final GameMode gameMode;

    public Computer(Color color, GameMode gameMode) {
        super(color);
        this.gameMode = gameMode;
    }

    /**
     * Конструктор компирования
     * @param player
     */
    public Computer(Player player) {
        super(player.color);
        gameMode = ((Computer)player).getGameMode();
    }

    @Override
    public Cell chooseTheCell(Game game) {
        if (gameMode == GameMode.Easy) {
            return chooseTheCellAtEasyMode(game);
        } else {
            return chooseTheCellAtHardMode(game);
        }
    }

    /**
     * Выбирает клетку, если компьютер в продвинутом режиме
     * @param game текущая игра
     * @return выбранная клетка
     */
    public Cell chooseTheCellAtHardMode(Game game) {
        String message = "Ходит компьютер, у которого белые фишки.";
        System.out.println(message);
        if (GameHandler.getNumberOfUsableCellsForPlayer(game, this) == 0) {
            System.out.println("Компьютер не может сходить.");
            possibilityToMove = !possibilityToMove;
            return null;
        }
        double max = -100;
        double firstValue;
        Game bufferGame;
        Cell cellShouldBeChosen = null;
        for (int number = 1; number <= 8; ++number) {
            for (char letter = 'a'; letter <= 'h'; ++letter) {
                if (game.getGameBoard().getField().getCell(number, letter).canBeChosen()) {
                    bufferGame = new Game(game);
                    firstValue = GameHandler.changeColorOfCells(bufferGame, this, bufferGame.getGameBoard().getField().getCell(number, letter), true);
                    bufferGame.getGameBoard().getField().getCell(number, letter).setChip(new Chip(Color.White));
                    GameHandler.changeColorOfCells(bufferGame, this, bufferGame.getGameBoard().getField().getCell(number, letter), false);
                    GameHandler.makeCellsUsual(bufferGame);
                    if (firstValue - bufferGame.getPlayerForBlack().getMaxNumberOfPointsManCanGet(bufferGame) > max) {
                        max = firstValue - bufferGame.getPlayerForBlack().getMaxNumberOfPointsManCanGet(bufferGame);
                        cellShouldBeChosen = game.getGameBoard().getField().getCell(number, letter);
                    }
                }
            }
        }
        possibilityToMove = !possibilityToMove;
        return cellShouldBeChosen;
    }

    /**
     * Выбирает клетку, если компьютер в лёгком режиме
     * @param game текущая игра
     * @return выбранная клетка
     */
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

    public GameMode getGameMode() {
        return gameMode;
    }
}
