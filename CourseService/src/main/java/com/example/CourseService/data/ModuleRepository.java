package com.example.CourseService.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    @Query("select s from Module s where s.moduleName= ?1")
    List<Module> findModuleByModulename(String moduleName);
}
