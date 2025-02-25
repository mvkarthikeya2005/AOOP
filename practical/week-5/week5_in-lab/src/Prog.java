// File: src/Prog.java
import models.*;
import services.*;
import utils.InputValidator;
import java.util.Scanner;

public class Prog {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Information System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add Student ---");

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (!InputValidator.isValidId(id)) {
                        System.out.println("Invalid ID! Must be greater than zero.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (!InputValidator.isValidName(name)) {
                        System.out.println("Invalid Name! Only letters and spaces are allowed.");
                        break;
                    }

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter State: ");
                    String state = sc.nextLine();

                    System.out.print("Enter Country: ");
                    String country = sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = sc.nextLine();

                    System.out.print("Enter Course Duration (months): ");
                    int duration = sc.nextInt();

                    Address address = new Address(city, state, country);
                    Course course = new Course(courseName, duration);
                    Student student = new Student(id, name, dept, address, course);

                    studentService.addStudent(student);
                    break;

                case 2:
                    studentService.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    Student foundStudent = studentService.findStudentById(searchId);

                    if (foundStudent != null) {
                        System.out.println("\n--- Student Found ---");
                        foundStudent.displayInfo();
                    } else {
                        System.out.println("Student not found with ID: " + searchId);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
