package kirillnasyrov.models.field;

import kirillnasyrov.models.cell.Cell;

public class Field {
    private Cell[][] field = new Cell[8][8];

    public Field() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                field[i][j] = new Cell((char)(97 + i), j + 1);
            }
        }
    }

    public Cell getCell(char letter, int number) {
        return field[(int)letter - 97][number - 1];
    }

    public void setCell(Cell cell) {
        field[(int)cell.getLetter() - 97][cell.getNumber() - 1] = cell;
    }
}
