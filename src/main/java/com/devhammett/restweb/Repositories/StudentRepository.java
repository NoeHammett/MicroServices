package com.devhammett.restweb.Repositories;

import com.devhammett.restweb.Models.StudentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

    
}
