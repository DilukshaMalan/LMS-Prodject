package com.example.malan.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.userName = ?1")
    List<Student> findStudentByUsername(String userName);

    @Query("select s from Student s where s.course = ?1")
    List<Student> findStudentByCourse(String course);
    @Query("select s from Student s where s.batchId= ?1")
    List<Student> findStudentByBatch(String batchId);

    List<Student> findByUserNameIsNull();



}
