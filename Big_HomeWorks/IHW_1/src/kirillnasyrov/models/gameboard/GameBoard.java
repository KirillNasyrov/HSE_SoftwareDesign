package kirillnasyrov.models.gameboard;

import kirillnasyrov.models.field.Field;

public class GameBoard {
    private final Field field;
    private int numberOfBlack;
    private int numberOfWhite;

    public GameBoard() {
        field  = new Field();
        numberOfBlack = 2;
        numberOfWhite = 2;
    }

    public GameBoard(GameBoard gameBoard) {
        numberOfBlack = gameBoard.getNumberOfBlack();
        numberOfWhite = gameBoard.getNumberOfWhite();
        field = new Field(gameBoard.getField());
    }

    public Field getField() {
        return field;
    }

    public int getNumberOfBlack() {
        return numberOfBlack;
    }

    public int getNumberOfWhite() {
        return numberOfWhite;
    }

    public void setNumberOfBlack(int numberOfBlack) {
        this.numberOfBlack = numberOfBlack;
    }

    public void setNumberOfWhite(int numberOfWhite) {
        this.numberOfWhite = numberOfWhite;
    }
}
