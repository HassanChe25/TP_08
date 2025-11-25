package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
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
        Student student = new Student();
        student.setFirstname("Charlie");
        student.setEmail("Algeria");
        studentRepository.save(student);

        List<Student> students = studentRepository.findAll();
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getFirstName()).isEqualTo("Charlie");
    }
}
