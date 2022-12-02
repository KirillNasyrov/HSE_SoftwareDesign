package kirillnasyrov.models.player;

import kirillnasyrov.models.consoleworker.ConsoleReader;
import kirillnasyrov.game.Game;
import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Color;

public class Player {
    protected boolean possibilityToMove;
    protected final Color color;
    protected final Color oppositeColor;

    public Player(Color color) {
        possibilityToMove = false;
        this.color = color;
        oppositeColor = color == Color.Black ? Color.White : Color.Black;
    }

    public Player(Player player) {
        color = player.getColor();
        oppositeColor = player.getOppositeColor();
        possibilityToMove = player.canMove();
    }

    public Cell chooseTheCell(Game game) {
        String message = color == Color.Black ? "Ходит игрок у которого черные фишки." : "Ходит игрок у которого белые фишки.";
        System.out.println(message);
        if (GameHandler.getNumberOfUsableCellsForPlayer(game, this) == 0) {
            System.out.println("Игрок не может сходить.");
            possibilityToMove = !possibilityToMove;
            return null;
        }

        int number = ConsoleReader.getNumberOfCell();
        char letter = ConsoleReader.getLetterOfCell();
        if (game.getGameBoard().getField().getCell(number, letter).canBeChosen()) {
            possibilityToMove = !possibilityToMove;
            return game.getGameBoard().getField().getCell(number, letter);
        } else {
            throw new RuntimeException("Ошибка. Неверный выбор клетки");
        }
    }

    public final double getMaxNumberOfPointsManCanGet(Game game) {
        GameHandler.findCellsCanBeChosen(game, this);
        double max = 0;
        for (int number = 1; number <= 8; ++number) {
            for (char letter = 'a'; letter <= 'h'; ++letter) {
                if (game.getGameBoard().getField().getCell(number, letter).canBeChosen()) {
                    if (GameHandler.changeColorOfCells(game, this, game.getGameBoard().getField().getCell(number, letter), true) > max) {
                        max = GameHandler.changeColorOfCells(game, this, game.getGameBoard().getField().getCell(number, letter), true);
                    }
                }
            }
        }
        GameHandler.makeCellsUsual(game);
        return max;
    }

    public Color getColor() {
        return color;
    }

    public Color getOppositeColor() {
        return oppositeColor;
    }

    public void setPossibilityToMove(boolean possibilityToMove) {
        this.possibilityToMove = possibilityToMove;
    }

    public boolean canMove() {
        return possibilityToMove;
    }
}
