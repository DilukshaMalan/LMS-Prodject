package com.example.CourseService.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByCourseName(String name);
    List<Course> findByCourseType(String type);
    List<Course> findByCourseTypeAndCourseName(String type, String name);
}
