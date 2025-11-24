package com.example.demo.Model;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String  email;


    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "university_id")
    private University university;
    public Student() {
    }


    @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public University getUniversity() {
        return university;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String first_name) {
        this.firstName = first_name;
    }

    public void setLastname(String last_name) {
        this.lastName = lastName;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}