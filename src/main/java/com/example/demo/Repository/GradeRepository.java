package com.example.demo.Repository;
import com.example.demo.Model.Grade;
import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
        @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId")
        List<Grade> findGradesByStudentId(@Param("studentId") int studentId);

        @Query("""
                SELECT SUM(g.value * g.coff) / SUM(g.coff)
                FROM Grade g
                WHERE g.student.id = :studentId
                """)
         Double findMoyenneByStudentId(@Param("studentId") int studentId);

         

        @Query("""
                SELECT g.student.id AS studentId,
                g.student.firstName AS firstName,
                g.student.lastName AS lastName,
                SUM(g.value * g.coff) / SUM(g.coff) AS moyenne
                FROM Grade g
                GROUP BY g.student.id, g.student.firstName, g.student.lastName
                ORDER BY moyenne DESC LIMIT 10
                """)
        List<Object> findStudentsOrderedByMoyenne();





}
