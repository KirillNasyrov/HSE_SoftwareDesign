package kirillnasyrov.models.cell;

import kirillnasyrov.models.chip.Chip;

public class Cell {
    private char letter;
    private int number;
    private boolean emptiness;
    private Chip chip;

    public Cell(char letter, int number) {
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
        return number;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
        emptiness = false;
    }
}
