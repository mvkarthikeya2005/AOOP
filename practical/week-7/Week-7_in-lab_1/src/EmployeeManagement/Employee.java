package EmployeeManagement;

//File: src/Employee.java
public class Employee {
 private int id;
 private String name;
 private String department;
 private double salary;

 // Constructor
 public Employee(int id, String name, String department, double salary) {
     this.id = id;
     this.name = name;
     this.department = department;
     this.salary = salary;
 }

 // Getters
 public int getId() { return id; }
 public String getName() { return name; }
 public String getDepartment() { return department; }
 public double getSalary() { return salary; }

 // Override toString() for easy display
 @Override
 public String toString() {
     return String.format("ID: %d, Name: %s, Department: %s, Salary: %.2f", id, name, department, salary);
 }
}

