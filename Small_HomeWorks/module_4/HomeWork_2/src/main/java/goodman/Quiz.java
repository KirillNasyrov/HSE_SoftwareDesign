package goodman;

import goodman.models.Question;
import goodman.models.QuestionCategory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quiz {
    public final QuizHttpClient quizHttpClient;
    public final ConsoleHandler consoleHandler = new ConsoleHandler();
    private int numberOfCorrectAnswers = 0;
    private int numberOfWrongAnswers = 0;

    private static final Logger logger = LogManager.getLogger(Quiz.class);

    public Quiz(QuizHttpClient quizHttpClient) {
        this.quizHttpClient = quizHttpClient;
    }

    public void start() {
        Question question;
        String answer = "";
        while (!answer.equals("/quit")) {
            int typeOfQuestion = consoleHandler.getTypeOfQuestion();
            if (typeOfQuestion == 1) {
                try {
                    question = quizHttpClient.getRandomQuestion();

                    answer = consoleHandler.getAnswerToQuestion(question);

                    logger.info("Asking new question: {}", question.getQuestion());
                    if (question.isAnswerValid(answer)) {
                        ++numberOfCorrectAnswers;
                        consoleHandler.getValidationOfQuestion(true);
                    } else {
                        ++numberOfWrongAnswers;
                        consoleHandler.getValidationOfQuestion(false);
                    }
                } catch (URISyntaxException | IOException | InterruptedException e) {
                    System.out.println("Произошла какая-то ошибка");
                    logger.error("An error occurred while running the game: {}", e.getMessage(), e);
                    return;
                }
            } else {
                try {
                    List<QuestionCategory> categories = quizHttpClient.getCategories(consoleHandler.getNumberCategories());
                    int numberOfCategory = consoleHandler.getCategory(categories);
                    --numberOfCategory;

                    question = quizHttpClient.getQuestionByCategory(categories.get(numberOfCategory));

                    answer = consoleHandler.getAnswerToQuestion(question);
                    if (question.isAnswerValid(answer)) {
                        ++numberOfCorrectAnswers;
                        consoleHandler.getValidationOfQuestion(true);
                    } else {
                        ++numberOfWrongAnswers;
                        consoleHandler.getValidationOfQuestion(false);
                    }
                } catch (URISyntaxException | IOException | InterruptedException e) {
                    System.out.println("Произошла какая-то ошибка");
                    logger.error("An error occurred while running the game: {}", e.getMessage(), e);
                    return;
                }
            }
        }

        consoleHandler.printFinalStatistics(numberOfCorrectAnswers, numberOfWrongAnswers);
    }
}
