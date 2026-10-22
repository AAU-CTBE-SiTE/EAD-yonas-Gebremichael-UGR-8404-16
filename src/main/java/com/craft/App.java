package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // CREATE
    public static void createStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    // READ
    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Student.class, id);
    }

    // UPDATE: Name only (Page 8)
    public static void updateStudentName(String newName, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setName(newName);
        entityManager.getTransaction().commit();
    }

    // UPDATE: Name and Tech (Page 10)
    public static void updateStudentNameAndTech(String newName, String newTech, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setName(newName);
        student.setTech(newTech);
        entityManager.getTransaction().commit();
    }

    // DELETE (Page 11)
    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        // Test UPDATE: Change Mohammed Ali (ID 2) to "Alemayehu"
        updateStudentName("Alemayehu", 2);

        // Fetch and print ID 2 to verify the update
        System.out.println("Updated student: " + getStudentById(2));
    }
}