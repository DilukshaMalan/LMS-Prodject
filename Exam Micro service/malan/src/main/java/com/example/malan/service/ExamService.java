package com.example.malan.service;

import com.example.malan.data.Exam;
import com.example.malan.data.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    // New feature: find exams by paper name
    public List<Exam> findExamsByPaperName(String paperName) {
        return examRepository.findByPaperName(paperName);
    }



    // New feature: find exams by subject
    public List<Exam>  findExamsBySubject(String subject) {
        return examRepository.findExamsBySubject(subject);
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam getExamById(int examId) {
        Optional<Exam> exam = examRepository.findById(examId);
        return exam.orElse(null);
    }

    public void deleteExamById(int examId) {
        examRepository.deleteById(examId);
    }

    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }
}
