package kirillnasyrov.models.player;

import kirillnasyrov.models.consoleworker.ConsoleReader;
import kirillnasyrov.game.Game;
import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Color;

/**
 * Класс, описываюий игрока
 */
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

    public final int chooseTheMove() {
        return ConsoleReader.getNumberOfMove();
    }

    /**
     * Отменяет предыдущий ход игрока
     * @return состояние игры после отмены хода игрока
     */
    public final Game undoMove() {
        if (!GameHandler.stackOfGames.isEmpty()) {
            GameHandler.stackOfGames.pop();
            return GameHandler.stackOfGames.pop();
        } else {
            throw new RuntimeException("Вы ни разу не сходили");
        }
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

    /**
     * Считает, сколько максимум фишек поменяют цвет в пользу игрока
     * @param game текщая игра
     * @return максимальное количество, которые поменяют цвет в пользу игрока
     */
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
