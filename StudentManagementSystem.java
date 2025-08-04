import java.util.*;

class Student {
    @SuppressWarnings("FieldMayBeFinal")
    private int rollNo;
    private String name;
    private String course;
    private double marks;

    public Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("-----------------------------------");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Marks      : " + marks);
        System.out.println("-----------------------------------");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

public class StudentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= STUDENT MANAGEMENT SYSTEM =========");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Update Marks by Roll Number");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAll();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> updateMarks();
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Marks (out of 100): ");
        double marks = scanner.nextDouble();

        Student student = new Student(rollNo, name, course, marks);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    private static void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Roll Number to Search: ");
        int rollNo = scanner.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        int rollNo = scanner.nextInt();
        boolean removed = false;

        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getRollNo() == rollNo) {
                iterator.remove();
                removed = true;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    private static void updateMarks() {
        System.out.print("Enter Roll Number to Update Marks: ");
        int rollNo = scanner.nextInt();
        boolean updated = false;

        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();
                s.setMarks(newMarks);
                System.out.println("Marks updated successfully.");
                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    public static void setScanner(Scanner scanner) {
        StudentManagementSystem.scanner = scanner;
    }

    public static void setStudentList (ArrayList<Student> studentList) {
        StudentManagementSystem.studentList = studentList;
    }
}