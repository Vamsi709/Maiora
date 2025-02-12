package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Create a new student
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // 2. Get all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 3. Get students between 18 and 25 years old
    @GetMapping("/age")
    public List<Student> getStudentsBetween18And25() {
        return studentService.getStudentsBetween18And25();
    }

    // 4. Calculate age and update the student
    @PutMapping("/update/{id}")
    public Student calculateAndUpdateAge(@PathVariable Long id) {
        return studentService.calculateAndUpdateAge(id);
    }
}