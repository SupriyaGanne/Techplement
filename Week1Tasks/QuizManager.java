package Week1Tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizManager {
    private Map<String, Quiz> quizzes;

    public QuizManager() {
        quizzes = new HashMap<>();
        addPredefinedQuizzes();
    }

    private void addPredefinedQuizzes() {
        Quiz quiz1 = new Quiz("General Knowledge");
        quiz1.addQuestion("What is the capital of France?", List.of("Berlin", "Madrid", "Paris", "Rome"), 2);
        quiz1.addQuestion("Who wrote 'To Kill a Mockingbird'?", List.of("Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"), 0);

        Quiz quiz2 = new Quiz("Science");
        quiz2.addQuestion("What is the chemical symbol for water?", List.of("H2O", "O2", "CO2", "NaCl"), 0);
        quiz2.addQuestion("What planet is known as the Red Planet?", List.of("Earth", "Mars", "Jupiter", "Saturn"), 1);

        quizzes.put(quiz1.getTitle(), quiz1);
        quizzes.put(quiz2.getTitle(), quiz2);
    }

    public void createQuiz(String title) {
        if (quizzes.containsKey(title)) {
            System.out.println("Quiz already exists.");
        } else {
            quizzes.put(title, new Quiz(title));
            System.out.println("Quiz '" + title + "' created.");
        }
    }

    public void addQuestionToQuiz(String title, String questionText, List<String> options, int correctAnswerIndex) {
        if (quizzes.containsKey(title)) {
            quizzes.get(title).addQuestion(questionText, options, correctAnswerIndex);
            System.out.println("Question added to quiz '" + title + "'.");
        } else {
            System.out.println("Quiz not found.");
        }
    }

    public int takeQuiz(String title) {
        if (quizzes.containsKey(title)) {
            Quiz quiz = quizzes.get(title);
            return quiz.takeQuiz();
        } else {
            System.out.println("Quiz not found.");
            return 0;
        }
    }

    public void listQuizzes() {
        System.out.println("Available Quizzes:");
        int index = 1;
        for (String title : quizzes.keySet()) {
            System.out.println(index++ + ". " + title);
        }
    }

    public String getQuizTitle(int index) {
        int currentIndex = 0;
        for (String title : quizzes.keySet()) {
            if (currentIndex == index) {
                return title;
            }
            currentIndex++;
        }
        return null;
    }

    public int getQuizCount() {
        return quizzes.size();
    }

    public int getTotalQuestions(String title) {
        if (quizzes.containsKey(title)) {
            return quizzes.get(title).getTotalQuestions();
        } else {
            return 0;
        }
    }
}
