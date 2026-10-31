package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");

        // Ask for the bean twice
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);

        // By default, Spring uses Singleton scope (both point to the exact SAME object)
        System.out.println("Are both instances the same? " + (student1 == student2));
    }
}