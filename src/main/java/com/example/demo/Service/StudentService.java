package com.example.demo.Service;
import com.example.demo.Model.Grade;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService  {
    @Autowired
    private StudentRepository studentRepository;
    public Student saveStudent(Student student) {
        // 🔹 احفظ الطالب الآن
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Object> getAllStudentsUniversity() {
        return studentRepository.getAllStudentsUniversity();
    }

    public List<Object> findStudentsByUniversity(String univName) {
        return studentRepository.findStudentsByUniversity(univName);
    }

    public void deleteStudentById(int id) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            studentRepository.delete(student);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
    public void updateStudent(Student std, String name) {
        Student student = studentRepository.findByfirstName(name);
        if (student != null) {
            
            student.setFirst_name(std.getFirstName());
            student.setLast_name(std.getLastName());
            student.setUniversity(std.getUniversity());
            student.setEmail(std.getEmail());
           

            studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with name: " + name);
        }
    }

    public Student OneStudent(int id){
        return studentRepository.findById(id);
    }

    public Student OneStudent(String Name){
        return studentRepository.findByfirstName(Name);
    }
    
    public void associateUniversity(Student std,int id){
      Student student =studentRepository.findById(id);
      if (student != null){
         student.setUniversity(std.getUniversity());
         studentRepository.save(student);
      }
      else {
            throw new RuntimeException("Student not found with id: " + id);
        }

    }



}
