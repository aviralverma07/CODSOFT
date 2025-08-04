import java.util.Scanner;

public class MarksCalculator {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println(" Invalid number of subjects. Please enter a positive number.");
            return;
        }

        int[] marks = new int[numSubjects];
        int total = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println(" Invalid input! Marks must be between 0 and 100.");
                i--; 
            } else {
                marks[i] = mark;
                total += mark;
            }
        }

        double percentage = (double) total / numSubjects;

        String grade;
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
            grade = "F";
        }

        System.out.println("\n RESULT SUMMARY:");
        System.out.println("Total Marks: " + total + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
