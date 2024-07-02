package Week1Tasks;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuizManager quizManager = new QuizManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Create Quiz");
            System.out.println("2. Add Question to Quiz");
            System.out.println("3. Take Quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            if (choice == 1) {
                System.out.print("Enter quiz title: ");
                String title = scanner.nextLine();
                quizManager.createQuiz(title);
            } else if (choice == 2) {
                System.out.print("Enter quiz title: ");
                String title = scanner.nextLine();
                System.out.print("Enter the question: ");
                String question = scanner.nextLine();
                System.out.print("Enter options (comma-separated): ");
                String[] optionsArray = scanner.nextLine().split(",");
                System.out.print("Enter the correct answer (option number): ");
                int correctAnswerIndex = scanner.nextInt() - 1;  
                quizManager.addQuestionToQuiz(title, question, Arrays.asList(optionsArray), correctAnswerIndex);
            } else if (choice == 3) {
                quizManager.listQuizzes();
                if (quizManager.getQuizCount() > 0) {
                    System.out.print("Select a quiz by number: ");
                    int quizChoice = scanner.nextInt() - 1;  
                    String selectedQuizTitle = quizManager.getQuizTitle(quizChoice);
                    if (selectedQuizTitle != null) {
                        int score = quizManager.takeQuiz(selectedQuizTitle);
                        System.out.println("Your score: " + score + "/" + quizManager.getTotalQuestions(selectedQuizTitle));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } else {
                    System.out.println("No quizzes available.");
                }
            } else if (choice == 4) {
                System.out.println("Exited.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
