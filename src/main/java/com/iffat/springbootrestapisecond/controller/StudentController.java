package com.iffat.springbootrestapisecond.controller;

import com.iffat.springbootrestapisecond.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Iffat",
                "Khan"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
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
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with path variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/iffat/khan
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=iffat&lastName=khan
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP POST Request
    @PostMapping("create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring Boot REST API that handles HTTP PUT Request updating existing student
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP DELETE Request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Deleted id: " + studentId + " successfully");
    }
}
