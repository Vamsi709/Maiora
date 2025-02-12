package com.example.demo.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // Save a student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get students between the age of 18 and 25
    public List<Student> getStudentsBetween18And25() {
        return studentRepository.findByAgeBetween(18, 25);
    }

    // Update student age after calculating it
    public Student calculateAndUpdateAge(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        student.getAge();
        return studentRepository.save(student);
    }
}
