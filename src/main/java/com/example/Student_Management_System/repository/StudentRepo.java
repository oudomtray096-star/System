package com.example.Student_Management_System.repository;

import com.example.Student_Management_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
