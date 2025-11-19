package com.example.demo.Repository;
import com.example.demo.Model.Student;
import com.example.demo.Model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer>{


}
