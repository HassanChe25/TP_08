package com.example.demo;
// JUnit 5 annotations and Spring Boot testing utilities 
import org.junit.jupiter.api.*; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat; 
import java.util.List; 
 
// Indicates this is a Spring Boot test that loads the full application context 
@SpringBootTest
@ActiveProfiles("test")
@Transactional
// Specifies the order in which test methods will be executed 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 

public class ControllerTest {
        @Autowired 
        private StudentRepository studentRepository;
    // First test: verifies that a student can be saved to the repository 
    @Test 
    @Order(1) // Ensures this test runs first 
    void shouldSaveStudent() { 
        // Create a new student object 
        Student student = new Student(); 
        student.setFirstname("Charlie");
        student.setEmail("Algeria"); 
 
        // Save the student to the H2 in-memory database 
        studentRepository.save(student); 
 
        // Assert that the repository now contains exactly one record 
        assertThat(studentRepository.count()).isEqualTo(1); 
    } 
 
    // Second test: verifies that all students can be retrieved correctly 
    @Test 
    @Order(2) // Ensures this test runs after shouldSaveStudent() 
    void shouldFindAllStudents() { 
        // Fetch all students from the repository 
        List<Student> students = studentRepository.findAll(); 
 
        // Assert that there is exactly one student in the list 
        assertThat(students).hasSize(1); 
 

 
        // Assert that the student's name is "Charlie" 
        assertThat(students.get(0).getFirstName()).isEqualTo("Charlie"); 
    } 
}
