// File: src/services/StudentService.java
package services;

import models.Student;

public interface StudentService {
    void addStudent(Student student);
    void displayAllStudents();
    Student findStudentById(int id);
}
