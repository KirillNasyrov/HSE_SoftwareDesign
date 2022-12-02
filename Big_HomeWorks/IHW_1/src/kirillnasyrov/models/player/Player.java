package kirillnasyrov.models.player;

import kirillnasyrov.ConsoleReader;
import kirillnasyrov.Game;
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
            throw new RuntimeException("Ошибка. Неверный выбор клетки.");
        }
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
