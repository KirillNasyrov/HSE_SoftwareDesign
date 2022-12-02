package kirillnasyrov.models.cell;

import kirillnasyrov.models.chip.Chip;

public class Cell {
    private char letter;
    private int number;
    private boolean emptiness;
    private Chip chip;
    private boolean possibilityForChoice;

    public Cell(int number, char letter) {
        setLetter(letter);
        setNumber(number);
        emptiness = true;
        chip = null;
    }

    public void setLetter(char value) {
        if (value < 'a' || value > 'h') {
            throw new IllegalArgumentException("Wrong letter");
        } else {
            letter = value;
        }
    }

    public void setNumber(int value) {
        if (value < 1 || value > 8) {
            throw new IllegalArgumentException("Wrong number");
        } else {
            number = value;
        }
    }

    public boolean isEmpty() {
        return emptiness;
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {

        return this.number;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
        emptiness = false;
    }

    public Chip getChip() {
        if (!isEmpty()) {
            return chip;
        } else {
            throw new RuntimeException("клетка пустая");
        }
    }

    public void setPossibilityForChoice(boolean possibilityForChoice) {
        this.possibilityForChoice = possibilityForChoice;
    }

    public boolean canBeChosen() {
        return possibilityForChoice;
    }
}
