package kirillnasyrov.handlers;

import kirillnasyrov.models.consoleworker.ConsoleReader;
import kirillnasyrov.game.Game;
import kirillnasyrov.game.GameMode;
import kirillnasyrov.models.cell.Cell;
import kirillnasyrov.models.chip.Chip;
import kirillnasyrov.models.field.Field;
import kirillnasyrov.models.player.Computer;
import kirillnasyrov.models.player.Player;
import kirillnasyrov.models.chip.Color;
import kirillnasyrov.view.ConsolePainter;

import java.util.Stack;

/**
 * Класс со статическими методами, предназначенный для обработки игровых действий.
 */
public class GameHandler {
    public static Stack<Game> stackOfGames = new Stack<>();
    private static int maxNumberOfPoints = 0;

    /**
     * Устанавливает режим игры
     * @param game игра, которой будет установлен режим игры
     */
    public static void chooseMode(Game game) {
        game.setGameMode(ConsoleReader.getGameMode());
    }

    /**
     * Устанавливает клетки, куда можнт сходить игрок
     * @param game действующая игра
     * @param player игрок, который делает ход
     */
    public static void findCellsCanBeChosen(Game game, Player player) {
        makeCellsUsual(game);
        for (int number = 1; number <= 8; ++number) {
            for (char letter = 'a'; letter <= 'h'; ++letter) {
                if (!game.getGameBoard().getField().getCell(number, letter).isEmpty()) {
                    if (game.getGameBoard().getField().getCell(number, letter).getChip().getColor() == player.getOppositeColor()) {
                        checkCell(game.getGameBoard().getField(), game.getGameBoard().getField().getCell(number, letter), player);
                    }
                }
            }
        }
    }

    /**
     * Проверяет, можно ли сходить на данную клетку
     * @param field игровое поле
     * @param cell клетка
     * @param player игрок, который делает ход
     */
    public static void checkCell(Field field, Cell cell, Player player) {
        checkHorizontalCells(field, cell, player);
        checkVerticalCells(field, cell, player);
        checkLeftDiagonalCells(field, cell, player);
        checkRightDiagonalCells(field, cell, player);
    }

    /**
     * Проверяет клетки по горизонтали рядом с выбранной клеткой
     * @param field игровое поле
     * @param cell выбранная клетка
     * @param player игрок, который делает ход
     */
    public static void checkHorizontalCells(Field field, Cell cell, Player player) {
        if (cell.getLetter() + 1 < 'i' && field.getCell(cell.getNumber(), (char) (cell.getLetter() + 1)).isEmpty()) {
            char startLetter = cell.getLetter();
            int number = cell.getNumber();
            while (startLetter >= 'a') {
                if (!field.getCell(number, startLetter).isEmpty()) {
                    if (field.getCell(number, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        --startLetter;
                    } else if (field.getCell(number, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(number, (char) (cell.getLetter() + 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else if (cell.getLetter() - 1 >= 'a' && field.getCell(cell.getNumber(), (char) (cell.getLetter() - 1)).isEmpty()) {
            char startLetter = cell.getLetter();
            int number = cell.getNumber();
            while (startLetter <= 'h') {
                if (!field.getCell(number, startLetter).isEmpty()) {
                    if (field.getCell(number, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        ++startLetter;
                    } else if (field.getCell(number, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(number, (char) (cell.getLetter() - 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }


    /**
     * Проверяет клетки по вертикали рядом с выбранной клеткой
     * @param field игровое поле
     * @param cell выбранная клетка
     * @param player игрок, который делает ход
     */
    public static void checkVerticalCells(Field field, Cell cell, Player player) {
        if (cell.getNumber() - 1 >= 1 && field.getCell(cell.getNumber() - 1, cell.getLetter()).isEmpty()) {
            int startNumber = cell.getNumber();
            char letter = cell.getLetter();

            while (startNumber <= 8) {
                if (!field.getCell(startNumber, letter).isEmpty()) {
                    if (field.getCell(startNumber, letter).getChip().getColor() == player.getOppositeColor()) {
                        ++startNumber;
                    } else if (field.getCell(startNumber, letter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() - 1, letter).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else if (cell.getNumber() + 1 <= 8 && field.getCell(cell.getNumber() + 1, cell.getLetter()).isEmpty()) {
            int startNumber = cell.getNumber();
            char letter = cell.getLetter();

            while (startNumber >= 1) {
                if (!field.getCell(startNumber, letter).isEmpty()) {
                    if (field.getCell(startNumber, letter).getChip().getColor() == player.getOppositeColor()) {
                        --startNumber;
                    } else if (field.getCell(startNumber, letter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() + 1, letter).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }


    /**
     * Проверяет клетки по левой диагонали рядом с выбранной клеткой
     * @param field игровое поле
     * @param cell выбранная клетка
     * @param player игрок, который делает ход
     */
    public static void checkLeftDiagonalCells(Field field, Cell cell, Player player) {
        if (cell.getNumber() - 1 >= 1
                && cell.getLetter() - 1 >= 'a'
                && field.getCell(cell.getNumber() - 1, (char) (cell.getLetter() - 1)).isEmpty()) {
            int startNumber = cell.getNumber();
            char startLetter = cell.getLetter();

            while (startNumber <= 8 && startLetter <= 'h') {
                if (!field.getCell(startNumber, startLetter).isEmpty()) {
                    if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        ++startNumber;
                        ++startLetter;
                    } else if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() - 1, (char) (cell.getLetter() - 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else if (cell.getNumber() + 1 <= 8
                && cell.getLetter() + 1 <= 'h'
                && field.getCell(cell.getNumber() + 1, (char) (cell.getLetter() + 1)).isEmpty()) {
            int startNumber = cell.getNumber();
            char startLetter = cell.getLetter();

            while (startNumber >= 1 && startLetter >= 'a') {
                if (!field.getCell(startNumber, startLetter).isEmpty()) {
                    if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        --startNumber;
                        --startLetter;
                    } else if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() + 1, (char) (cell.getLetter() + 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Проверяет клетки по правой диагонали рядом с выбранной клеткой
     * @param field игровое поле
     * @param cell выбранная клетка
     * @param player игрок, который делает ход
     */
    public static void checkRightDiagonalCells(Field field, Cell cell, Player player) {
        if (cell.getNumber() - 1 >= 1
                && cell.getLetter() + 1 <= 'h'
                && field.getCell(cell.getNumber() - 1, (char) (cell.getLetter() + 1)).isEmpty()) {
            int startNumber = cell.getNumber();
            char startLetter = cell.getLetter();

            while (startNumber <= 8 && startLetter >= 'a') {
                if (!field.getCell(startNumber, startLetter).isEmpty()) {
                    if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        ++startNumber;
                        --startLetter;
                    } else if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() - 1, (char) (cell.getLetter() + 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else if (cell.getNumber() + 1 <= 8
                && cell.getLetter() - 1 >= 'a'
                && field.getCell(cell.getNumber() + 1, (char) (cell.getLetter() - 1)).isEmpty()) {
            int startNumber = cell.getNumber();
            char startLetter = cell.getLetter();

            while (startNumber >= 1 && startLetter <= 'h') {
                if (!field.getCell(startNumber, startLetter).isEmpty()) {
                    if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getOppositeColor()) {
                        --startNumber;
                        ++startLetter;
                    } else if (field.getCell(startNumber, startLetter).getChip().getColor() == player.getColor()) {
                        field.getCell(cell.getNumber() + 1, (char) (cell.getLetter() - 1)).setPossibilityForChoice(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }


    /**
     * Запускает игру
     * @param game текущая игра
     */
    public static void startGame(Game game) {
        if (game.getGameMode() == GameMode.PlayerVsPlayer) {
            game.setPlayerForBlack(new Player(Color.Black));
            game.setPlayerForWhite(new Player(Color.White));
        } else {
            game.setPlayerForBlack(new Player(Color.Black));
            game.setPlayerForWhite(new Computer(Color.White, game.getGameMode()));
        }
        game.getPlayerForBlack().setPossibilityToMove(true);
        while (!game.isOver()) {
            if (game.getPlayerForBlack().canMove()) {
                findCellsCanBeChosen(game, game.getPlayerForBlack());
                ConsolePainter.paintGameBoard(game.getGameBoard());
                if (game.getGameMode() != GameMode.PlayerVsPlayer) {
                    int move = game.getPlayerForBlack().chooseTheMove();
                    if (move == 2) {
                        try {
                            game = game.getPlayerForBlack().undoMove();
                            ConsolePainter.paintGameBoard(game.getGameBoard());
                        } catch (RuntimeException exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                }
                stackOfGames.push(new Game(game));
                Cell chosenCell;
                while (true) {
                    try {
                        chosenCell = game.getPlayerForBlack().chooseTheCell(game);
                        break;
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                        System.out.println("Попробуйте заново выбрать клетку\n");
                    }
                }
                if (chosenCell != null) {
                    chosenCell.setChip(new Chip(Color.Black));
                    game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                    changeColorOfCells(game, game.getPlayerForBlack(), chosenCell, false);
                    makeCellsUsual(game);
                }
                game.getPlayerForWhite().setPossibilityToMove(true);
            } else {
                findCellsCanBeChosen(game, game.getPlayerForWhite());
                stackOfGames.push(new Game(game));
                ConsolePainter.paintGameBoard(game.getGameBoard());
                Cell chosenCell;
                while (true) {
                    try {
                        chosenCell = game.getPlayerForWhite().chooseTheCell(game);
                        break;
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                        System.out.println("попробуйте заново выбрать клетку\n");
                    }
                }
                if (chosenCell != null) {
                    chosenCell.setChip(new Chip(Color.White));
                    game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                    changeColorOfCells(game, game.getPlayerForWhite(), chosenCell, false);
                    makeCellsUsual(game);
                }
                game.getPlayerForBlack().setPossibilityToMove(true);
            }
        }
        ConsolePainter.paintGameBoard(game.getGameBoard());
        System.out.println("Игра завершена.");
        if (game.getGameBoard().getNumberOfBlack() > game.getGameBoard().getNumberOfWhite()) {
            System.out.println("Победил игрок с чёрными фишками. " + game.getGameBoard().getNumberOfBlack() + " очков.");
            if (game.getGameBoard().getNumberOfBlack() > maxNumberOfPoints) {
                maxNumberOfPoints = game.getGameBoard().getNumberOfBlack();
            }
        } else if (game.getGameBoard().getNumberOfBlack() < game.getGameBoard().getNumberOfWhite()) {
            if (game.getGameMode() != GameMode.PlayerVsPlayer) {
                System.out.println("Победил компьютер с белыми фишками. " + game.getGameBoard().getNumberOfWhite() + " очков.");
            } else {
                System.out.println("Победил игрок с белыми фишками. " + game.getGameBoard().getNumberOfWhite() + " очков.");
                if (game.getGameBoard().getNumberOfWhite() > maxNumberOfPoints) {
                    maxNumberOfPoints = game.getGameBoard().getNumberOfWhite();
                }
            }
        } else {
            System.out.println("Ничья." + game.getGameBoard().getNumberOfBlack() + " очков у каждого.");
            if (game.getGameBoard().getNumberOfBlack() > maxNumberOfPoints) {
                maxNumberOfPoints = game.getGameBoard().getNumberOfBlack();
            }
        }
        System.out.println("Максимально большое количество очков, полученные выигравшим человеком: " + maxNumberOfPoints);
    }


    /**
     * Считает количество клеток, куда может сходить игрок
     * @param game текущая игра
     * @param player игрок, который делает ход
     * @return количество клеток, куда может сходить игрок
     */
    public static int getNumberOfUsableCellsForPlayer(Game game, Player player) {
        int sum = 0;
        findCellsCanBeChosen(game, player);
        for (int i = 1; i <= 8; ++i) {
            for (char j = 'a'; j <='h'; ++j) {
                if (game.getGameBoard().getField().getCell(i, j).canBeChosen()) {
                    ++sum;
                }
            }
        }
        return sum;
    }


    /**
     * Делает клетки поля недоступными для того, чтобы делать ход на них
     * @param game текущая игра
     */
    public static void makeCellsUsual(Game game) {
        for (int i = 1; i <= 8; ++i) {
            for (char j = 'a'; j <='h'; ++j) {
                if (game.getGameBoard().getField().getCell(i, j).canBeChosen()) {
                    game.getGameBoard().getField().getCell(i, j).setPossibilityForChoice(false);
                }
            }
        }
    }

    /**
     * Меняет цвет клеток или считает количество клеток, которые поменяют цвет если поставить фишку на выбранную клетку
     * @param game текущая игра
     * @param player игрок, который делает ход
     * @param cell выбранная клетка
     * @param needOnlyToCountCells определяет, нужно ли только посчитать количество клеток, которые поменяют цвет или поменять цвет клеток
     * @return 0, если параметр needOnlyToCountCells = false, иначе число клеток, которые поменяют цвет
     */
    public static int changeColorOfCells(Game game, Player player, Cell cell, boolean needOnlyToCountCells) {
        int sum = 0;

        char letter = cell.getLetter();
        int number = cell.getNumber();

        //1
        char iteratorLetter = cell.getLetter();
        int iteratorNumber;
        --iteratorLetter;
        while (iteratorLetter >= 'a') {
            if (!game.getGameBoard().getField().getCell(number, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(number, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    --iteratorLetter;
                } else {
                    for (char i = (char) (letter - 1); i > iteratorLetter; --i) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(number, i).getChip().changeColor();
                        } else {
                            if (number == 1 || number == 8 || i == 'h') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }

        //2
        iteratorLetter = letter;
        iteratorNumber = number;
        --iteratorNumber;
        --iteratorLetter;
        while (iteratorLetter >= 'a' && iteratorNumber >= 1) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    --iteratorLetter;
                    --iteratorNumber;
                } else {
                    int i;
                    char j;
                    for (i = number - 1, j = (char) (letter - 1); i > iteratorNumber && j > iteratorLetter; --i, --j) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, j).getChip().changeColor();
                        } else {
                            if (i == 8 || j == 'h') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }

                    }
                    break;
                }
            } else {
                break;
            }
        }

        //3
        iteratorNumber = number;
        --iteratorNumber;
        while (iteratorNumber >= 1) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, letter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, letter).getChip().getColor() == player.getOppositeColor()) {
                    --iteratorNumber;
                } else {
                    int i;
                    for (i = number - 1; i > iteratorNumber; --i) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, letter).getChip().changeColor();
                        } else {
                            if (i == 8 || letter == 'a' || letter == 'h') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }

                    }
                    break;
                }
            } else {
                break;
            }
        }

        //4
        iteratorLetter = letter;
        iteratorNumber = number;
        --iteratorNumber;
        ++iteratorLetter;
        while (iteratorLetter <= 'h' && iteratorNumber >= 1) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    --iteratorNumber;
                    ++iteratorLetter;
                } else {
                    int i;
                    char j;
                    for (i = number - 1, j = (char) (letter + 1); i > iteratorNumber && j < iteratorLetter; --i, ++j) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, j).getChip().changeColor();
                        } else {
                            if ( i == 8 || j == 'a') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }

        //5
        iteratorLetter = letter;
        ++iteratorLetter;
        while (iteratorLetter <= 'h') {
            if (!game.getGameBoard().getField().getCell(number, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(number, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    ++iteratorLetter;
                } else {
                    char j;
                    for (j = (char) (letter + 1); j < iteratorLetter; ++j) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(number, j).getChip().changeColor();
                        } else {
                            if (number == 1 || number == 8 || j == 'a') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }

        //6
        iteratorLetter = letter;
        iteratorNumber = number;
        ++iteratorNumber;
        ++iteratorLetter;
        while (iteratorLetter <= 'h' && iteratorNumber <= 8) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    ++iteratorLetter;
                    ++iteratorNumber;
                } else {
                    int i;
                    char j;
                    for (i = number + 1, j = (char) (letter + 1); i < iteratorNumber && j < iteratorLetter; ++i, ++j) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, j).getChip().changeColor();
                        } else {
                            if (i == 1 || j == 'a') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }

        //7
        iteratorNumber = number;
        ++iteratorNumber;
        while (iteratorNumber <= 8) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, letter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, letter).getChip().getColor() == player.getOppositeColor()) {
                    ++iteratorNumber;
                } else {
                    int i;
                    for (i = number + 1; i < iteratorNumber; ++i) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, letter).getChip().changeColor();
                        } else {
                            if (i == 1 || letter == 'a' || letter == 'h') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }

        //8
        iteratorLetter = letter;
        iteratorNumber = number;
        ++iteratorNumber;
        --iteratorLetter;
        while (iteratorLetter >= 'a' && iteratorNumber <= 8) {
            if (!game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).isEmpty()) {
                if (game.getGameBoard().getField().getCell(iteratorNumber, iteratorLetter).getChip().getColor() == player.getOppositeColor()) {
                    ++iteratorNumber;
                    --iteratorLetter;
                } else {
                    int i;
                    char j;
                    for (i = number + 1, j = (char) (letter - 1); i < iteratorNumber && j > iteratorLetter; ++i, --j) {
                        if (!needOnlyToCountCells) {
                            if (player.getOppositeColor() == Color.White) {
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() - 1);
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() + 1);
                            } else {
                                game.getGameBoard().setNumberOfBlack(game.getGameBoard().getNumberOfBlack() - 1);
                                game.getGameBoard().setNumberOfWhite(game.getGameBoard().getNumberOfWhite() + 1);
                            }
                            game.getGameBoard().getField().getCell(i, j).getChip().changeColor();
                        } else {
                            if (i == 1 || j == 'h') {
                                sum += 2;
                            } else {
                                ++sum;
                            }
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }
        if ((number == 1 || number == 8) && (letter == 'a' || letter == 'h')) {
            sum += 0.8;
        } else if ((number == 1 || number == 8) || (letter == 'a' || letter == 'h')) {
            sum += 0.4;
        }
        return sum;
    }
}
