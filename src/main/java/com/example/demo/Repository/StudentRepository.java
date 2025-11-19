package com.example.demo.Repository;
import com.example.demo.Model.Student;
import com.example.demo.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    
    @Query("SELECT s.firstName, s.lastName, u.name FROM Student s JOIN s.university u")
    List<Object> getAllStudentsUniversity();

    @Query("SELECT s.firstName, s.lastName, u.name FROM Student s JOIN s.university u WHERE u.name = :param")
    List<Object> findStudentsByUniversity(@Param("param") String univName);


   
    Student findByfirstName(String firstName);

    Student findById(int id);
}
