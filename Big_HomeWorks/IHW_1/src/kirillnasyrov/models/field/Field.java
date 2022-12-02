package kirillnasyrov.models.field;

import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Chip;
import kirillnasyrov.models.chip.Color;

public class Field {
    private final Cell[][] field = new Cell[8][8];

    public Field() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                field[i][j] = new Cell(i + 1, (char) (97 + j));
            }
        }
        this.getCell(4, 'd').setChip(new Chip(Color.Black));
        this.getCell(5, 'e').setChip(new Chip(Color.Black));
        this.getCell(4, 'e').setChip(new Chip(Color.White));
        this.getCell(5, 'd').setChip(new Chip(Color.White));
    }

    public Field(Field field) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                this.field[i][j] = new Cell(field.getCell(i + 1, (char) (97 + j)));
            }
        }
    }

    public Cell getCell(int number, char letter) {

        return field[number - 1][(int) letter - 97];
    }

    public void setCell(Cell cell) {
        field[cell.getNumber() - 1][(int) cell.getLetter() - 97] = cell;
    }
}
