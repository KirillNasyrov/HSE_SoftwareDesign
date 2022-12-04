package kirillnasyrov.models.consoleworker;

import kirillnasyrov.game.GameMode;

import java.util.Scanner;

/**
 * Класс, который работает с консолью и считывает данные от пользователя
 */
public class ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Считвыает номер клетки
     * @return номер клетки
     */
    public static int getNumberOfCell() {
        int number;
        while (true) {
            try {
                System.out.print("введите номер клетки: ");
                number = Integer.parseInt(scanner.next().trim());
                if (number < 1 || number > 8) {
                    System.out.println("надо выбрать номер от '1' до '8'");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("неверный ввод");
            }
        }
        return number;
    }

    /**
     * Считывает выбор, какое действие сделать при ходе
     * @return номер действия
     */
    public static int getNumberOfMove() {
        int number;
        while (true) {
            try {
                System.out.print("выберите действие (1 - выбрать клетку; 2 - отменить ход): ");
                number = Integer.parseInt(scanner.next().trim());
                if (number < 1 || number > 2) {
                    System.out.println("надо выбрать номер от '1' или '2'");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("неверный ввод");
            }
        }
        return number;
    }

    /**
     * Считывает букву клетки
     * @return букву клетки
     */
    public static char getLetterOfCell() {
        char letter;
        while (true) {
            try {
                System.out.print("введите букву клетки: ");
                String string = scanner.next().trim();
                letter = string.charAt(0);
                if (letter < 'a' || letter > 'h' || string.length() != 1) {
                    System.out.println("надо выбрать букву от 'a' до 'h'");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("невеный ввод");
            }
        }
        return letter;
    }

    /**
     * Считывает режим игры
     * @return режим игры
     */
    public static GameMode getGameMode() {
        int number;
        while (true) {
            try {
                System.out.print("выберите режим игры (1 - лёгкий; 2 - продвинутый; 3 - pvp): ");
                number = Integer.parseInt(scanner.next().trim());
                if (number < 1 || number > 3) {
                    System.out.println("надо выбрать номер от '1' до '3'");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("неверный ввод");
            }
        }
        if (number == 1) {
            return GameMode.Easy;
        } else if (number == 2) {
            return GameMode.Hurd;
        } else {
            return GameMode.PlayerVsPlayer;
        }
    }

    /**
     * Считывает выбор, начать игру заново или выйти
     * @return номер действия
     */
    public static int getNumberOfChoice() {
        int number;
        while (true) {
            try {
                System.out.print("Сделайте выбор (1 - сыграть заново; 2 - выйти из игры): ");
                number = Integer.parseInt(scanner.next().trim());
                if (number < 1 || number > 2) {
                    System.out.println("Надо выбрать номер от '1' или '2'");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Неверный ввод");
            }
        }
        return number;
    }
}
