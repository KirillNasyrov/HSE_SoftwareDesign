package kirillnasyrov;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Person[] array;

    public static void main(String[] args) {
        array = new Person[7];
        array[0] = new Person("Кирилл", "Насыров");
        array[1] = new Person("Яна", "Шулепа");
        array[2] = new Person("Анна", "Лаптева");
        array[3] = new Person("Андрей", "Шмайхель");
        array[4] = new Person("Никита", "Ягло");
        array[5] = new Person("Влад", "Хмельницкий");
        array[6] = new Person("Тимофей", "Кочетов");
        HomeWork work = new HomeWork(array);
        startProcess(work);

    }

    public static void startProcess(HomeWork work) {
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        while (!Objects.equals(answer, "exit")) {
            System.out.println("Введите команду ( /r, /l, exit )");
            answer = scanner.nextLine();
            if (Objects.equals(answer, "/l")) {
                work.print();
            } else if (Objects.equals(answer, "/r")) {
                int randomIndex = (int) (Math.random() * 6);
                if (work.students.get(array[randomIndex]) == null) {
                    System.out.println("Отвечает " + array[randomIndex].getInformation() + '.');
                    System.out.println("Присутствует ли на паре? (y / n)");
                    String yesOrNo = scanner.nextLine();
                    if (Objects.equals(yesOrNo, "y")) {
                        work.students.put(array[randomIndex], 10);
                        System.out.println("Оценка за ответ: 10");
                    } else if (Objects.equals(yesOrNo, "n")) {
                        work.students.put(array[randomIndex], 0);
                        System.out.println("Оценка за ответ: 0");
                    } else {
                        System.out.println("Вы Ввели неправильную команду");
                    }
                } else {
                    System.out.println("Отвечает " + array[randomIndex].getInformation() + '.');
                    System.out.println("Студент был выбран");
                }
            } else {
                if (!Objects.equals(answer, "exit")) {
                    System.out.println("Вы Ввели неправильную команду");
                }
            }
        }
        work.print();
    }
}

