package com.example.demo.Service;

import com.example.demo.Model.University;
import com.example.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;
    public University saveUniv(University university) {
        return universityRepository.save(university);
    }
    public List<University> getAllUniv() {
        return universityRepository.findAll();
    }
}
