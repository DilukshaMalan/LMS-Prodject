package com.example.malan.controller;

import com.example.malan.data.Exam;
import com.example.malan.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController


public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping(path ="/exams")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @PostMapping(path ="/exams")
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }


    @GetMapping(path ="/exams/{examId}")
    public Exam getExamById(@PathVariable int examId) {
        return examService.getExamById(examId);
    }

    @GetMapping(path ="/exams",params = "papername")
    public List<Exam> getExamsByPaperName(@RequestParam String papername) {
        return examService.findExamsByPaperName(papername);
    }


    @GetMapping(path ="/exams",params = "subject")
    public List<Exam> getExamsBySubject(@RequestParam String subject) {
        return examService.findExamsBySubject(subject);
    }

    @DeleteMapping(path ="/exams/{examId}")
    public void deleteExamById(@PathVariable int examId) {
        examService.deleteExamById(examId);
    }

    @PutMapping(path ="/exams")
    public Exam updateExam(@RequestBody Exam exam) {
        return examService.updateExam(exam);
    }
}
