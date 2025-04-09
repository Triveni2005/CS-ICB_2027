import java.util.*;
import java.io.*;

public class FlashcardApp {
    // Define flashcard class
    static class Flashcard {
        String question;
        String answer;

        Flashcard(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    private static ArrayList<Flashcard> flashcards = new ArrayList<>();
    private static int correctCount = 0;
    private static int incorrectCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nFlashcard App Menu:");
            System.out.println("1. Add a Flashcard");
            System.out.println("2. Test Flashcards");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFlashcard(scanner);
                    break;
                case 2:
                    testFlashcards(scanner);
                    break;
                case 3:
                    viewResults();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Method to add flashcards
    private static void addFlashcard(Scanner scanner) {
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        System.out.print("Enter the answer: ");
        String answer = scanner.nextLine();

        flashcards.add(new Flashcard(question, answer));
        System.out.println("Flashcard added successfully!");
    }

    // Method to test flashcards
    private static void testFlashcards(Scanner scanner) {
        if (flashcards.isEmpty()) {
            System.out.println("No flashcards available. Please add some first.");
            return;
        }

        for (Flashcard flashcard : flashcards) {
            System.out.println("\nQuestion: " + flashcard.question);
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(flashcard.answer)) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + flashcard.answer);
                incorrectCount++;
            }
        }
    }

    // Method to view the results of correct and incorrect answers
    private static void viewResults() {
        System.out.println("\nResults:");
        System.out.println("Correct Answers: " + correctCount);
        System.out.println("Incorrect Answers: " + incorrectCount);
        System.out.println("Total Flashcards: " + flashcards.size());
    }
}
