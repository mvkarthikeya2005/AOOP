package EmployeeManagement;

//File: src/EmployeeSorter.java
import java.util.Comparator;

public class EmployeeSorter {
 // Comparator to sort by salary (ascending)
 public static Comparator<Employee> bySalaryAsc = Comparator.comparingDouble(Employee::getSalary);

 // Comparator to sort by salary (descending)
 public static Comparator<Employee> bySalaryDesc = Comparator.comparingDouble(Employee::getSalary).reversed();

 // Comparator to sort by name (alphabetical order)
 public static Comparator<Employee> byName = Comparator.comparing(Employee::getName);

 // Comparator to sort by department (alphabetical order)
 public static Comparator<Employee> byDepartment = Comparator.comparing(Employee::getDepartment);
}

