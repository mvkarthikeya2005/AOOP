package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to initialize the employee details
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters for each attribute
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Override toString for better output representation
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class DepartmentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getDepartment().compareTo(e2.getDepartment());
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Add employees to the list
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "Engineering", 70000));
        employees.add(new Employee(3, "Charlie", "Sales", 60000));
        employees.add(new Employee(4, "David", "Engineering", 80000));
        
        // Sort by salary (ascending)
        Collections.sort(employees, new SalaryComparator());
        System.out.println("Sorted by Salary (ascending):");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort by salary (descending)
        Collections.sort(employees, Collections.reverseOrder(new SalaryComparator()));
        System.out.println("\nSorted by Salary (descending):");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort by name
        Collections.sort(employees, new NameComparator());
        System.out.println("\nSorted by Name:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort by department
        Collections.sort(employees, new DepartmentComparator());
        System.out.println("\nSorted by Department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
