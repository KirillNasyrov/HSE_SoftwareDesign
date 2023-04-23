package goodman;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Random;

import goodman.models.Question;
import goodman.models.QuestionCategory;
import goodman.response.QuizResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1


public class QuizHttpClient {
    private final HttpClient client;
    private static final String RANDOM_URI = "https://jservice.io/api/random";
    private static final String CATEGORIES_URI = "https://jservice.io/api/categories?count=";
    private static final String CLUES_URI = "https://jservice.io/api/clues";
    private static final Logger logger = LogManager.getLogger(QuizHttpClient.class);

    public QuizHttpClient(HttpClient client) {
        this.client = client;
    }

    public Question getRandomQuestion() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(RANDOM_URI))
                .version(HttpClient.Version.HTTP_1_1)
                .GET()
                .build();

        logger.debug("Sending GET request to " + request.uri());

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        logger.debug("Received response with status code " + response.statusCode()
                + " and body " + response.body());

        if (response.statusCode() == 200) {

            ObjectMapper objectMapper = new ObjectMapper();
            QuizResponse[] responses = objectMapper.readValue(response.body(), QuizResponse[].class);
            QuizResponse quizResponse = responses[0];
            return new Question(quizResponse.getQuestion(), quizResponse.getAnswer());
        } else if (response.statusCode() == 404) {
            logger.warn("The server cannot find the requested resource.");
            return null;
        } else if (response.statusCode() == 500) {
            logger.warn("Server error responses");
            return null;
        }
        return null;
    }

    public List<QuestionCategory> getCategories(int number) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(CATEGORIES_URI + number))
                .version(HttpClient.Version.HTTP_1_1)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            ObjectMapper objectMapper = new ObjectMapper();
            QuestionCategory[] questionCategories = objectMapper.readValue(response.body(), QuestionCategory[].class);
            return List.of(questionCategories);
        } else if (response.statusCode() == 404) {
            logger.warn("The server cannot find the requested resource.");
            return null;
        } else if (response.statusCode() >= 500 && response.statusCode() <= 599) {
            logger.warn("Server error responses");
            return null;
        }
        return null;
    }

    public Question getQuestionByCategory(QuestionCategory questionCategory) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(CLUES_URI))
                .headers("category", Integer.toString(questionCategory.getId()))
                .version(HttpClient.Version.HTTP_1_1)
                .GET()
                .build();

        logger.debug("Sending GET request to " + request.uri());

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        logger.debug("Received response with status code " + response.statusCode()
                + " and body " + response.body());

        if (response.statusCode() == 200) {

            ObjectMapper objectMapper = new ObjectMapper();
            QuizResponse[] responses = objectMapper.readValue(response.body(), QuizResponse[].class);

            Random random = new Random();
            QuizResponse quizResponse = responses[random.nextInt(responses.length)];
            return new Question(quizResponse.getQuestion(), quizResponse.getAnswer());
        } else if (response.statusCode() == 404) {
            logger.warn("The server cannot find the requested resource.");
            return null;
        } else if (response.statusCode() >= 500 && response.statusCode() <= 599) {
            logger.warn("Server error responses");
            return null;
        }
        return null;
    }
}
