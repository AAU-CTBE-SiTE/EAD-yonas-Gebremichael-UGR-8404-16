package com.craft;

import org.springframework.stereotype.Component;

@Component
public class StudentService {

    public void addStudent(String name) {
        System.out.println("Business Logic: Saving student [" + name + "] to database.");
    }

    public String getStudentTech(int id) {
        System.out.println("Business Logic: Fetching tech for student ID " + id);
        return "Java & Spring Boot";
    }

    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Student age must be 18 or older!");
        }
        System.out.println("Business Logic: Age " + age + " is valid.");
    }
}