package com.example.demo.Controller;


import com.example.demo.Model.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.UniversityService;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
        @Autowired
        private UniversityService universityService;
        @PostMapping("/add")
        public String add(@RequestBody University university) {
            universityService.saveUniv(university);
            return "New unive is added";
        }
        @GetMapping("/getAll")
        public List<University> getAlluniv() {
            return universityService.getAllUniv();
        }


}
