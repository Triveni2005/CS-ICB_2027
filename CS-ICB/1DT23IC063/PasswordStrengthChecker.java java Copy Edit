import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int score = 0;

        if (password.length() >= 8)
            score++;
        if (password.matches(".*[A-Z].*"))
            score++;
        if (password.matches(".*[a-z].*"))
            score++;
        if (password.matches(".*[0-9].*"))
            score++;
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"))
            score++;

        System.out.println("\nPassword Analysis:");

        if (score == 5) {
            System.out.println("Strong Password");
        } else if (score >= 3) {
            System.out.println("Moderate Password");
        } else {
            System.out.println("Weak Password");
        }

        sc.close();
    }
}
