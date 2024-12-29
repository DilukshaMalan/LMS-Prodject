package com.example.CourseService.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
    @Query("select s from Batch s where s.course = ?1")
    List<Batch> findByByCourse( String course);
}
