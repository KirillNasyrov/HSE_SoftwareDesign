package goodman_screbber;

import java.util.Scanner;

public class ConsoleWorker {
    private final Scanner scanner;

    public ConsoleWorker() {
        this.scanner = new Scanner(System.in);
    }

    public String getStringPathOfOrders() {
        System.out.print("Введите путь до json файла заказов: ");
        return scanner.nextLine();
    }

    public String getStringPathOfMenuDishes() {
        System.out.print("Введите путь до json файла меню: ");
        return scanner.nextLine();
    }

    public String getStringPathOfDishCards() {
        System.out.print("Введите путь до json файла карточек блюд: ");
        return scanner.nextLine();
    }

    public String getStringPathOfCooks() {
        System.out.print("Введите путь до json файла поваров: ");
        return scanner.nextLine();
    }
}
