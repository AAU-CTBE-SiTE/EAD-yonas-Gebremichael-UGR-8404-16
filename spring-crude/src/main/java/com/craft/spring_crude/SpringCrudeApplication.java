package com.craft.spring_crude;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCrudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudeApplication.class, args);
	}

	@Bean
	CommandLineRunner runCrud(StudentRepository repo) {
		return args -> {
			// 1. CREATE
			Student s1 = repo.save(new Student("Yonas", "yonas@example.com", "Java"));
			Student s2 = repo.save(new Student("Temp Student", "temp@example.com", "Python"));
			System.out.println("CREATED: " + s1);

			// 2. READ
			System.out.println("ALL STUDENTS: " + repo.findAll());

			// 3. UPDATE
			s1.setCourse("Spring Boot + MySQL");
			repo.save(s1);
			System.out.println("UPDATED: " + repo.findById(s1.getId()).orElse(null));

			// 4. DELETE
			repo.deleteById(s2.getId());
			System.out.println("AFTER DELETE: " + repo.findAll());
		};
	}
}