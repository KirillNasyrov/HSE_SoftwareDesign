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
                    if (question.isAnswerValid(answer)) {
                        ++numberOfCorrectAnswers;
                        consoleHandler.getValidationOfQuestion(true);
                    } else {
                        ++numberOfWrongAnswers;
                        consoleHandler.getValidationOfQuestion(false);
                    }
                } catch (URISyntaxException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    List<QuestionCategory> categories = quizHttpClient.getCategories(3);
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
                    throw new RuntimeException(e);
                }
            }
        }

        consoleHandler.printFinalStatistics(numberOfCorrectAnswers, numberOfWrongAnswers);
    }
}
