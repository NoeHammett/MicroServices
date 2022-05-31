package com.devhammett.restweb.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.devhammett.restweb.Models.StudentModel;
import com.devhammett.restweb.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/students", produces = "application/json")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/getAll")
    public ArrayList<StudentModel> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/getById/{id_Student}")
    public StudentModel getById(@PathVariable("id_Student")int id){
        return studentService.getStudentById(id);
    }

    @PostMapping(path = "/add")
    public String addStudent(@RequestBody StudentModel student){
        return studentService.addStudent(student);
    }
}
