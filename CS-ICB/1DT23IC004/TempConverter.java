import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        System.out.println("=== Temperature Converter ===");

        while (continueConversion) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("Temperature in Fahrenheit: " + fahrenheit);
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.println("Temperature in Celsius: " + celsius);
                    break;
                case 3:
                    continueConversion = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
