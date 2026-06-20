package com.example.Student_Management_System.controler;


import com.example.Student_Management_System.model.Student;
import com.example.Student_Management_System.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;       ///make obj from Studentservice service

    public StudentController(StudentService service){
        this.service = service;
    }


    //View all Students
    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    //Add Student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student){
        return service.saveStudent(student);
    }

    // Update Student
    @PutMapping ("/{id}")
    public Student udateStudent(
                    @PathVariable Long id,
                    @Valid @RequestBody Student student
    )  {
        return service.updateStudent(id,student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
         service.deleteStudent(id);
         return "Student deleted successfull";
    }

    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String name  ) {
        return service.searchStudent(name);
    }
}
