import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        double temperature, converted;

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            temperature = scanner.nextDouble();
            converted = (temperature * 9/5) + 32;
            System.out.println("Temperature in Fahrenheit: " + converted);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            temperature = scanner.nextDouble();
            converted = (temperature - 32) * 5/9;
            System.out.println("Temperature in Celsius: " + converted);
        } else {
            System.out.println("Invalid option!");
        }

        scanner.close();
    }
}
