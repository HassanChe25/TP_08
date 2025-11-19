package com.example.demo.Model;
import jakarta.persistence.*;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id ;
    private String name ;
    private String location;


    public University() {}
    @OneToMany(mappedBy = "university" ,cascade = CascadeType.ALL)

    public int getId_university() {
        return university_id;
    }

    public void setId_university(int university_id) {
        this.university_id= university_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUniversity_id() {
        return  university_id;
    }
}

