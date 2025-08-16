import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        initializeQuestions();
    }

    private void initializeQuestions() {
        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"},
            1
        ));
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"1. Jupiter", "2. Mars", "3. Venus", "4. Mercury"},
            2
        ));
        questions.add(new Question(
            "What is 2 + 2?",
            new String[]{"1. 3", "2. 4", "3. 5", "4. 6"},
            2
        ));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Answer each question by entering the option number (1-4).");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer;
            try {
                userAnswer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                i--; // Retry the same question
                continue;
            }

            if (userAnswer < 1 || userAnswer > 4) {
                System.out.println("Invalid option! Please choose between 1 and 4.");
                i--; // Retry the same question
                continue;
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + question.getCorrectAnswerIndex() + ".");
            }
        }

        displayResults();
        scanner.close();
    }

    private void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        double percentage = (double) score / questions.size() * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}