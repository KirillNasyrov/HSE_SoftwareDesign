package goodman.models;

public class Question {
    private final String question;
    private final String answer;
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean isAnswerValid(String userAnswer) {
        return answer.equals(userAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
