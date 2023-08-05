import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade() + ", Age: " + student.getAge());
        }
    }

    public void saveToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student);
            }
            System.out.println("Data saved to CSV file.");
        } catch (IOException e) {
            System.out.println("Error saving data to CSV file: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    // Skip the header line
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    String rollNumber = data[1];
                    String grade = data[2];
                    int age = Integer.parseInt(data[3]);
                    Student student = new Student(name, rollNumber, grade, age);
                    students.add(student);
                }
            }
            System.out.println("Data loaded from CSV file.");
        } catch (IOException e) {
            System.out.println("Error loading data from CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing age: " + e.getMessage());
        }
    }
    
}