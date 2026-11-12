package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService service = context.getBean(StudentService.class);

        System.out.println("--- 1. Testing @Around, @Before, and @After ---");
        service.addStudent("Yonas");

        System.out.println("\n--- 2. Testing @AfterReturning ---");
        service.getStudentTech(101);

        System.out.println("\n--- 3. Testing @AfterThrowing ---");
        try {
            service.validateAge(15);
        } catch (Exception ignored) {
        }
    }
}