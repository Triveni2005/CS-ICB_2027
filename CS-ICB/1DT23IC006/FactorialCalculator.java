import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();

        // Call the method to calculate the factorial
        long result = calculateFactorial(number);

        // Display the result
        System.out.println("Factorial of " + number + " is: " + result);
        
        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Method to calculate the factorial
    public static long calculateFactorial(int num) {
        long factorial = 1;
        
        // Check if the number is negative, as factorial is not defined for negative numbers
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }

        // Calculate the factorial
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
}
