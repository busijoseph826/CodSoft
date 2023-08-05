import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem managementSystem = new StudentManagementSystem();
        String filename = "student.csv";
        managementSystem.loadFromCSV(filename);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save data to CSV file");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student student = new Student(name, rollNumber, grade, age);
                    managementSystem.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter roll number of the student to remove: ");
                    String rollNumberToRemove = scanner.nextLine();
                    managementSystem.removeStudent(rollNumberToRemove);
                    break;

                case 3:
                    System.out.print("Enter roll number of the student to search: ");
                    String rollNumberToSearch = scanner.nextLine();
                    Student foundStudent = managementSystem.searchStudent(rollNumberToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found - Name: " + foundStudent.getName() +
                                ", Roll Number: " + foundStudent.getRollNumber() +
                                ", Grade: " + foundStudent.getGrade() +
                                ", Age: " + foundStudent.getAge());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    managementSystem.displayAllStudents();
                    break;

                case 5:
                    managementSystem.saveToCSV(filename);
                    break;

                case 6:
                    scanner.close();
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}