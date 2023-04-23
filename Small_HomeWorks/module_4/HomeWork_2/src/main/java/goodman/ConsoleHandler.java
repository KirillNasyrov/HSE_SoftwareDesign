package goodman;

import goodman.models.Question;
import goodman.models.QuestionCategory;

import java.util.List;
import java.util.Scanner;

public class ConsoleHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void printCategories(List<QuestionCategory> questionCategories) {
        int count = 1;
        for (var questionCategory : questionCategories) {
            System.out.println(count + ": " + questionCategory.getTitle());
            ++count;
        }
    }

    public int getTypeOfQuestion() {
        System.out.print("Вы хотите получить случайный вопрос(1) или на выбранную категорию(2)?: ");
        int answer = scanner.nextInt();
        while (answer != 1 && answer != 2) {
            System.out.print("Введите 1 или 2: ");
            answer = scanner.nextInt();
        }
        return answer;
    }

    public int getCategory(List<QuestionCategory> questionCategories) {
        printCategories(questionCategories);
        System.out.print("Введите номер категории: ");
        int answer = scanner.nextInt();
        while (answer < 1 || answer > questionCategories.size() + 1) {
            System.out.print("Введите верный номер категории: ");
            answer = scanner.nextInt();
        }
        return answer;
    }

    public int getNumberCategories() {
        System.out.print("Введите количество категорий категории(от 1 до 20): ");
        int answer = scanner.nextInt();
        if (answer < 1 || answer > 20) {
            answer = 5;
        }
        return answer;
    }

    public String getAnswerToQuestion(Question question) {
        System.out.println("Вопрос: " + question.getQuestion());
        System.out.print("Введите ответ: ");
        return scanner.next();
    }

    public void getValidationOfQuestion(boolean validation) {
        if (validation) {
            System.out.println("Ответ правильный");
        } else {
            System.out.println("Ответ неправильный");
        }
    }

    public void printFinalStatistics(int correct, int wrong) {
        System.out.println();
        System.out.println("Game over");
        System.out.println("Правильных ответов: " + correct);
        System.out.println("Неравильных ответов: " + wrong);
    }
}
