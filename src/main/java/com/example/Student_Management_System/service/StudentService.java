package com.example.Student_Management_System.service;


import com.example.Student_Management_System.model.Student;
import com.example.Student_Management_System.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo repo;


    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }


    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student saveStudent(Student student){
        return repo.save(student); //save to database
    }

    public Student updateStudent(Long id , Student student){
        Student existingStudent =
                repo.findById(id).orElseThrow();
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());

        return repo.save(existingStudent) ;
    }

    public void deleteStudent(Long id){
        repo.deleteById(id);
    }

    public List<Student> searchStudent(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }



}
