package com.example.malan.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    @Query("select s from Exam s where s.paperName = ?1")
    List<Exam> findByPaperName(String paperName);
    @Query("select s from Exam s where s.subject = ?1")
    List<Exam> findExamsBySubject(String subject);

}
