package com.example.CourseService.Service;

import com.example.CourseService.data.*;
import com.example.CourseService.data.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private BatchRepository batchRepository;

    // Course related methods

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }

    public List<Course> findCourseByType(String type) {
        return courseRepository.findByCourseType(type);
    }

    public List<Course> findCourseByTypeName(String type, String name) {
        return courseRepository.findByCourseTypeAndCourseName(type, name);
    }

    public List<Module> findModuleByModulename(String moduleName) {
        return moduleRepository.findModuleByModulename(moduleName);
    }

    public List<Batch>  findByByCourse(String course) {
        return batchRepository. findByByCourse(course);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    // Module related methods

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(int id) {
        return moduleRepository.findById(id);
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public void deleteModuleById(int id) {
        moduleRepository.deleteById(id);
    }

    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }

    public Batch addBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    public Optional<Batch> getBatchById(int batchId) {
        return batchRepository.findById(batchId);
    }

    public Batch updateBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public void deleteBatch(int batchId) {
        batchRepository.deleteById(batchId);
    }


}
