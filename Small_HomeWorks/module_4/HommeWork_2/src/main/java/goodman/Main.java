package goodman;

import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {
        QuizHttpClient httpClient = new QuizHttpClient(HttpClient.newHttpClient());
        Quiz quiz = new Quiz(httpClient);
        quiz.start();
    }
}