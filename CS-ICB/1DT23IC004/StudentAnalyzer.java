import java.util.Scanner;

public class StudentAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[5];
        int total = 0;

        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }

        double average = total / 5.0;
        String grade = getGrade(average);
        boolean pass = isPassed(marks);

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + (pass ? "Pass" : "Fail"));

        scanner.close();
    }

    private static boolean isPassed(int[] marks) {
        for (int mark : marks) {
            if (mark < 35) return false;
        }
        return true;
    }

    private static String getGrade(double avg) {
        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 55) return "C";
        else if (avg >= 35) return "D";
        else return "F";
    }
}
