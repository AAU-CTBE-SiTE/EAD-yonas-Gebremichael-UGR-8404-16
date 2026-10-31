package com.craft;

import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;
    private List<Subject> subjects; // <-- List of Subject beans

    public Student() {
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student Name: " + this.name);
        int index = 1;
        if (subjects != null) {
            for (Subject subject : subjects) {
                System.out.println("Subject " + index + ": " + subject.getSubjectName());
                index++;
            }
        }
    }
}