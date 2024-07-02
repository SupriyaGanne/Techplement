package Week1Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(String questionText, List<String> options, int correctAnswerIndex) {
        questions.add(new Question(questionText, options, correctAnswerIndex));
    }

    public int takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (Question q : questions) {
            System.out.println(q.getQuestionText());
            List<String> options = q.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            int answer = scanner.nextInt() - 1;
            if (answer == q.getCorrectAnswerIndex()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + (q.getCorrectAnswerIndex() + 1) + ". " + options.get(q.getCorrectAnswerIndex()));
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
