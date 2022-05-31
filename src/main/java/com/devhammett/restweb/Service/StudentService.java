package com.devhammett.restweb.Service;

import java.util.ArrayList; 

import com.devhammett.restweb.Models.StudentModel;
import com.devhammett.restweb.Repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository StudentRepository;

    public ArrayList<StudentModel> getAllStudents() {
        return (ArrayList<StudentModel>) StudentRepository.findAll();
    }

    public StudentModel getStudentById(int id) {
        return StudentRepository.findById(id).get();
    }

    public String addStudent(StudentModel student) {
        try{
            StudentRepository.save(student);
            return "Student added successfully";
        }catch(Exception e){
            return "Error \n" + e.getMessage();
        }
        
    }
    
}
