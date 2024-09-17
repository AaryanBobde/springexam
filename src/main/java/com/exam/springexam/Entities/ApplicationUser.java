package com.exam.springexam.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private int age;

    private String medicalHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    @ElementCollection
    private List<String> existingMedicalConditions;


    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<String> getExistingMedicalConditions() {
        return existingMedicalConditions;
    }

    public void setExistingMedicalConditions(List<String> existingMedicalConditions) {
        this.existingMedicalConditions = existingMedicalConditions;
    }

    public ApplicationUser(Long id, String name, String email, String password, int age, String medicalHistory, List<String> existingMedicalConditions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.existingMedicalConditions = existingMedicalConditions;
    }

    public ApplicationUser() {
    }


}
