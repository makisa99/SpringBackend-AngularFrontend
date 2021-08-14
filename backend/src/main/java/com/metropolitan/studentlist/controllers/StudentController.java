package com.metropolitan.studentlist.controllers;

import com.metropolitan.studentlist.payload.request.StudentDtoRequest;
import com.metropolitan.studentlist.payload.response.StudentDtoResponse;
import com.metropolitan.studentlist.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDtoResponse> createStudent(@RequestBody StudentDtoRequest studentDtoRequest) {
        StudentDtoResponse studentDtoResponse = studentService.addStudent(studentDtoRequest);

        return new ResponseEntity<>(studentDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDtoResponse> getAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDtoResponse> getById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDtoResponse> updateStudent(@PathVariable(name = "id") long id,
                                                            @RequestBody StudentDtoRequest studentDtoRequest) {
        StudentDtoResponse studentDtoResponse = studentService.updateStudent(id, studentDtoRequest);

        return new ResponseEntity<>(studentDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") long id) {
        studentService.deleteStudent(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}