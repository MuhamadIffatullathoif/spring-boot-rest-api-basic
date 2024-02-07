package com.iffat.springbootrestapisecond.controller;

import com.iffat.springbootrestapisecond.bean.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Iffat",
                "Khan"
        );
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                1,
                "Iffat",
                "Khan"
        ));
        students.add(new Student(
                2,
                "Iffat",
                "Khan"
        ));
        return students;
    }

    // Spring Boot REST API with path variable
    // {id} - URI template variable
    // http://localhost:8080/student/1/iffat/khan
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
