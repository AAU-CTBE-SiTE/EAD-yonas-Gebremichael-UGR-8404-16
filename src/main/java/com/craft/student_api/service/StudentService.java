package com.craft.student_api.service;

import com.craft.student_api.model.Student;
import com.craft.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return repository.findById(id).map(existing -> {
            existing.setFirstName(updatedStudent.getFirstName());
            existing.setLastName(updatedStudent.getLastName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setDepartment(updatedStudent.getDepartment());
            return repository.save(existing);
        }).orElse(null);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}