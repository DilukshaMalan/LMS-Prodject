package com.example.malan.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    @Query("select s from Result s where s.studentId = ?1")

    List<Result> findResultsByStudentId(int studentId); // Add query method for finding results by student ID
    @Query("select s from Result s where s.examId = ?1")
    List<Result> findResultsByExamId(String examId); // Add query method for finding results by exam ID


}
