// File: src/models/Course.java
package models;

public class Course {
    private String courseName;
    private int courseDuration;  // in months

    // Constructor
    public Course(String courseName, int courseDuration) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseDuration + " months)";
    }
}
