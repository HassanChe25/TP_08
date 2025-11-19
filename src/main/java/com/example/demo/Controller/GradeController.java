package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Model.Grade;
import com.example.demo.Service.GradeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

     @GetMapping("/average/{studentId}")
     public double getAverage(@PathVariable("studentId") int studentId) {
        return gradeService.getMoyeenByStudentId(studentId);
     }

     @GetMapping("/ordered-by-average")
      List<Object> getStudentsOrderedByMoyenne() {
        return gradeService.getStudentsOrderedByMoyenne();
     }

      

    @PostMapping("/add")
    public String add(@RequestBody Grade  grade) {
        gradeService.saveGrade(grade);
        return "New grade is added";
    }
}
