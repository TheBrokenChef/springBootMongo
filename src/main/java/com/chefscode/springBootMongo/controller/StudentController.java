package com.chefscode.springBootMongo.controller;

import com.chefscode.springBootMongo.dto.StudentRequest;
import com.chefscode.springBootMongo.model.Student;
import com.chefscode.springBootMongo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/allStudents")
    public List<Student> fetchAllStudents(){
        return studentService.fetchAllStudents();
    }

    @PostMapping("/addStudent")
    public String insertStudent(@RequestBody StudentRequest studentRequest){
        String str = studentService.insertStudent(studentRequest);
        return str;
    }

    @PutMapping("/{email}")
    public String updateStudent(@PathVariable("email") String email, @RequestBody StudentRequest studentRequest){
        String str = studentService.updateStudent(email, studentRequest);
        return str;
    }

    @DeleteMapping("/{email}")
    public String deleteStudent(@PathVariable("email") String email){
        String str = studentService.deleteStudent(email);
        return str;
    }
}
