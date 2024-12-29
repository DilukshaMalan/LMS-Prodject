package com.example.malan.controller;

import com.example.malan.data.Student;
import com.example.malan.data.StudentRepository;
import com.example.malan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping(path="/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(path = "/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping(path="/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(path="/students", params = "userName")
    public List<Student> findStudentByUsername(@RequestParam String userName) {
        return studentService.findStudentByUsername(userName);
    }
    @GetMapping(path="/students", params = "course")
    public List<Student> findStudentByCourse(@RequestParam String course) {
        return studentService.findStudentByCourse(course);
    }
    @GetMapping(path="/students", params = "batchId")
    public List<Student> findStudentByBatch(@RequestParam String batchId) {
        return studentService.findStudentByBatch(batchId);
    }

    @DeleteMapping(path="/students/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path="/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/nullstudents")
    public List<Student> getStudentsWithNullUsername() {
        return studentService.getStudentsWithNullUsername();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setUserName(updatedStudent.getUserName());
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
