import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Temperature Converter ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        double inputTemp, convertedTemp;

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                inputTemp = scanner.nextDouble();
                convertedTemp = (inputTemp * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + convertedTemp);
                break;

            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                inputTemp = scanner.nextDouble();
                convertedTemp = (inputTemp - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + convertedTemp);
                break;

            default:
                System.out.println("Invalid option!");
        }

        scanner.close();
    }
}

