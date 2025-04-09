import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int[] grades;

    public Student(String name, int numSubjects) {
        this.name = name;
        this.grades = new int[numSubjects];
    }

    public String getName() {
        return name;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\nGrades: ");
        for (int grade : grades) {
            sb.append(grade).append(" ");
        }
        sb.append("\nAverage Grade: ").append(getAverageGrade());
        return sb.toString();
    }
}

public class StudentGradesManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grades Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Edit Student Grades");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    editStudentGrades();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] grades = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        scanner.nextLine();  // Consume newline character
        Student student = new Student(name, numSubjects);
        student.setGrades(grades);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void editStudentGrades() {
        System.out.print("Enter the name of the student to edit: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Editing grades for " + student.getName());
                int[] grades = student.getGrades();
                for (int i = 0; i < grades.length; i++) {
                    System.out.print("Enter new grade for subject " + (i + 1) + ": ");
                    grades[i] = scanner.nextInt();
                }
                student.setGrades(grades);
                System.out.println("Grades updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
