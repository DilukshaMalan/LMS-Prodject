package com.example.malan.service;

import com.example.malan.data.Student;

import com.example.malan.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findStudentByUsername(String userName) {
        return studentRepository.findStudentByUsername(userName);
    }
    public List<Student> findStudentByCourse(String course) {
        return studentRepository.findStudentByCourse(course);
    }
    public List<Student> findStudentByBatch(String batchId) {
        return studentRepository.findStudentByBatch(batchId);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentsWithNullUsername() {
        return studentRepository.findByUserNameIsNull();
    }

    public Optional<Student> updateStudentById(int id, String Username) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setUserName(Username);
            studentRepository.save(student);
        }
        return studentOptional;
    }





}

