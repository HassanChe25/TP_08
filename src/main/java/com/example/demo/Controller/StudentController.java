package com.example.demo.Controller;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/findStudUniv")
    public List<Object> findStudentsByUniversity(@RequestParam("univName") String univName) {
        return studentService.findStudentsByUniversity(univName);
    }
    @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable("id") int id) {
            studentService.deleteStudentById(id);
            return "Student with id " + id + " is deleted";
   }

    @GetMapping("/getOne")
    public Student getOneStudent(@RequestParam("id") int id) {
        return  studentService.OneStudent(id);

    }

     @GetMapping("/getByName")
    public Student getOneStudent(@RequestParam("Name") String Name) {
        return  studentService.OneStudent(Name);

    }



    @PutMapping("/update")
    public String put(@RequestBody Student student,@RequestParam("Name") String Name) {
        studentService.updateStudent(student,Name);
        return "New student is updated";
    }

    @PutMapping("/Associate/{id}")
    public String put(@RequestBody Student student ,@PathVariable("id")  int id){
        studentService.associateUniversity(student,id);
        return "student is associate";
    }
    




}
