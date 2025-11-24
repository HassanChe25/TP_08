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
@ActiveProfiles("test")  // يجب أن يتطابق مع اسم الملف: application-test.properties
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerTest {
    @Autowired 
    private StudentRepository studentRepository;
    
    @Test 
    @Order(1)
    void shouldSaveStudent() {
        Student student = new Student();
        student.setFirstname("Charlie");
        student.setEmail("Algeria");
        studentRepository.save(student);
        assertThat(studentRepository.count()).isEqualTo(1);
    }

    @Test 
    @Order(2)
    void shouldFindAllStudents() {
        List<Student> students = studentRepository.findAll();
        assertThat(students).hasSize(1);
        assertThat(students.get(0)).isEqualTo("Charlie");
    }
}

