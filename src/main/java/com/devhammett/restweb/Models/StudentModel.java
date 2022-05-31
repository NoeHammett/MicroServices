package com.devhammett.restweb.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//This class is a model for the Student with JPA

@Entity

public class StudentModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Student;

    @Size(min = 2, max = 30)
    private String name;
    private String lastname;

    @Email
    private String email;
    @Past
    private Date birthdate;

    public StudentModel() {
    }

    public StudentModel(Integer id_Student, String name, String lastname, String email, Date birthdate) {
        this.id_Student = id_Student;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
    }


    public Integer getId_Student() {
        return this.id_Student;
    }

    public void setId_Student(Integer id_Student) {
        this.id_Student = id_Student;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public Date setBirthdate() {
        return this.birthdate;
    }


}
