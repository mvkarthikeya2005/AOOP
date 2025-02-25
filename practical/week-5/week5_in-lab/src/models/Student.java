// File: src/models/Student.java
package models;

public class Student {
    private int id;
    private String name;
    private String department;
    private Address address;
    private Course course;

    // Constructor
    public Student(int id, String name, String department, Address address, Course course) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
        this.course = course;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public Address getAddress() { return address; }
    public Course getCourse() { return course; }

    // Display Student Info
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Address: " + address);
        System.out.println("Course: " + course);
        System.out.println("-----------------------------");
    }
}
