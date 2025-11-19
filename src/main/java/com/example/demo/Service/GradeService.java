package com.example.demo.Service;
import com.example.demo.Model.Grade;
import com.example.demo.Model.Student;
import com.example.demo.Repository.GradeRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }


    public double getMoyeenByStudentId(int studentId) {
        return gradeRepository.findMoyenneByStudentId(studentId);
    }


    public List<Object> getStudentsOrderedByMoyenne() {
        return gradeRepository.findStudentsOrderedByMoyenne();
    }


}
