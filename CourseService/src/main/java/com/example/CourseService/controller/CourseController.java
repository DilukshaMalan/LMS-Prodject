package com.example.CourseService.controller;

import com.example.CourseService.data.Course;
import com.example.CourseService.data.Module;
import com.example.CourseService.data.Batch;
import com.example.CourseService.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;



    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping(path = "/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping(path = "/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping(path = "/courses", params = "name")
    public List<Course> findCourseByName(@RequestParam String name) {
        return courseService.findCourseByName(name);
    }

    @GetMapping(path = "/courses", params = "type")
    public List<Course> findCourseByType(@RequestParam String type) {
        return courseService.findCourseByType(type);
    }

    @GetMapping(path = "/courses", params = {"type", "name"})
    public List<Course> findCourseByTypeName(@RequestParam String type, @RequestParam String name) {
        return courseService.findCourseByTypeName(type, name);
    }

    @DeleteMapping(path = "/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourseById(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }

    @PutMapping(path = "/courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setCourseId(id);
        return courseService.updateCourse(course);
    }
    @GetMapping(path="/modules", params = "moduleName")
    public List<Module> findModuleByModulename(@RequestParam String moduleName) {
        return courseService.findModuleByModulename(moduleName);
    }

    @GetMapping(path = "/modules")
    public List<Module> getAllModules() {
        return courseService.getAllModules();
    }

    @PostMapping(path = "/modules")
    @ResponseStatus(HttpStatus.CREATED)
    public Module createModule(@RequestBody Module module) {
        return courseService.createModule(module);
    }

    @GetMapping(path = "/modules/{id}")
    public Optional<Module> getModuleById(@PathVariable int id) {
        return courseService.getModuleById(id);
    }

    @DeleteMapping(path = "/modules/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModuleById(@PathVariable int id) {
        courseService.deleteModuleById(id);
    }

    @PutMapping(path = "/modules/{id}")
    public Module updateModule(@PathVariable String id, @RequestBody Module module) {
        module.setModuleId(id);
        return courseService.updateModule(module);
    }

    @PostMapping(path = "/batch")
    public Batch addBatch(@RequestBody Batch batch) {
        return courseService.addBatch(batch);

    }

    @GetMapping(path = "/batch")
    public List<Batch> getAllBatches() {
        return   courseService.getAllBatches();

    }

    @GetMapping(path = "/batch/{id}")
    public Optional<Batch> getBatchById(@PathVariable("id") int batchId) {
        return courseService.getBatchById(batchId);

    }
    @GetMapping(path="/batch", params = "course")
    public List<Batch>  findByByCourse(@RequestParam String course) {
        return courseService. findByByCourse(course);
    }

    @PutMapping(path = "/batch/{id}")
    public Batch updateBatch(@PathVariable("id") int batchId, @RequestBody Batch batch) {
        if (courseService.getBatchById(batchId).isPresent()) {
            batch.setBatchId(batchId);
          return courseService.updateBatch(batch);

        } else {
            return batch;
        }
    }

    @DeleteMapping(path = "/batch/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBatchById(@PathVariable int id) {
        courseService.deleteBatch(id);
    }



}




