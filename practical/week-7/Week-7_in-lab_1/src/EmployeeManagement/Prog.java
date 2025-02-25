package EmployeeManagement;

//File: src/Prog.java
import java.util.*;

public class Prog {
 public static void main(String[] args) {
     // Create a list of Employee objects
     List<Employee> employees = new ArrayList<>();
     employees.add(new Employee(101, "Vinay", "HR", 60000));
     employees.add(new Employee(102, "Nikhil", "Engineering", 75000));
     employees.add(new Employee(103, "Chetan", "Finance", 50000));
     employees.add(new Employee(104, "Samith", "Engineering", 80000));
     employees.add(new Employee(105, "Karthikeya", "HR", 62000));

     // Display original list
     System.out.println("Original Employee List:");
     displayEmployees(employees);

     // Sort by Salary (Ascending)
     employees.sort(EmployeeSorter.bySalaryAsc);
     System.out.println("\nSorted by Salary (Ascending):");
     displayEmployees(employees);

     // Sort by Salary (Descending)
     employees.sort(EmployeeSorter.bySalaryDesc);
     System.out.println("\nSorted by Salary (Descending):");
     displayEmployees(employees);

     // Sort by Name (Alphabetical)
     employees.sort(EmployeeSorter.byName);
     System.out.println("\nSorted by Name (Alphabetical):");
     displayEmployees(employees);

     // Sort by Department (Alphabetical)
     employees.sort(EmployeeSorter.byDepartment);
     System.out.println("\nSorted by Department (Alphabetical):");
     displayEmployees(employees);
 }

 // Method to display the employee list
 public static void displayEmployees(List<Employee> employees) {
     for (Employee e : employees) {
         System.out.println(e);
     }
 }
}

