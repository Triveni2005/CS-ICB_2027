
    import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Student Name
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        // Input: Marks for 5 subjects
        int[] marks = new int[5];
        int total = 0;

        System.out.println("Enter marks for 5 subjects (out of 100):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        // Calculate percentage
        double percentage = total / 5.0;
        String grade;

        // Determine grade
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        // Print Report
        System.out.println("\n--- Report Card ---");
        System.out.println("Name: " + name);
        System.out.println("Total: " + total + " / 500");
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}


