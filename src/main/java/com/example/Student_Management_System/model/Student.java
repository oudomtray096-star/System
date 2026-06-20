package com.example.Student_Management_System.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Database data model 

// In model we use to make table 
@Entity
@Table(name = "students")
@Getter                    // Generates all getters
@Setter                      // Generates all setters
@NoArgsConstructor // Generate empty constructor
@AllArgsConstructor // Generate Constructor with all fields
public class Student {
   

    @Id
    //Auto Id increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Student cannot be empty
    @NotBlank(message = "Name is required")
    private String name;

    // Email cannot be empty and must be valid
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // Phone Can not be empty
    @NotBlank(message = "Phone is required")
    private String phone;

//    //Default Constructor (require by JPA)
//    public Student(){
//
//    }
//    // Constructor with parameter
//    public Student(String name ,String  email,String phone){
//        this.email = email;
//        this.name = name ;
//        this.phone = phone;
//    }

}
