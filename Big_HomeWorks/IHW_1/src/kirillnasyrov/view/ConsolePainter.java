package kirillnasyrov.view;

import kirillnasyrov.models.gameboard.GameBoard;
import kirillnasyrov.models.chip.Color;

public class ConsolePainter {
    public static void paintGameBoard(GameBoard board) {
        for (int number = 1; number <= 8; ++number) {
            System.out.println("   ---------------------------------------------------");
            System.out.print(" " + number + " ");
            for (char letter = 'a'; letter <= 'h'; ++letter) {
                if (board.getField().getCell(number, letter).isEmpty()) {
                    if (board.getField().getCell(number, letter).canBeChosen()) {
                        System.out.print("|  ◌  ");
                    }
                    else {
                        System.out.print("|     ");
                    }
                } else {
                    if (board.getField().getCell(number, letter).getChip().getColor() == Color.White) {
                        System.out.print("|  ⚫  ");
                    } else {
                        System.out.print("|  ⚪  ");
                    }
                }
            }
            if (number == 4) {
                System.out.println("|   " + "white: " + board.getNumberOfWhite());
            } else if (number == 5) {
                System.out.println("|   " + "black: " + board.getNumberOfBlack());
            } else {
                System.out.println("|");
            }
        }
        System.out.println("   ---------------------------------------------------");
        System.out.println("      a     b     c     d     e     f     g     h   \n");
        System.out.print("Возможные ходы: [ ");

        for (int i = 1; i <= 8; ++i) {
            for (char j = 'a'; j <= 'h'; ++j) {
                if (board.getField().getCell(i, j).canBeChosen()) {
                    System.out.print(String.valueOf(i) + j + " ");
                }
            }
        }
        System.out.println(" ]");
    }
}
