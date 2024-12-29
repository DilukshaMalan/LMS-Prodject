package com.example.malan.controller;

import com.example.malan.data.Result;
import com.example.malan.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping(path="/results")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @PostMapping(path="/results")
    public Result createResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    @GetMapping(path="/results/{id}")
    public Result getResultById(@PathVariable int id) {
        return resultService.getResultById(id);
    }



    @DeleteMapping(path="/results//{id}")
    public void deleteResultById(@PathVariable int id) {
        resultService.deleteResultById(id);
    }

    @PutMapping(path="/results")
    public Result updateResult(@RequestBody Result result) {
        return resultService.updateResult(result);
    }

    @GetMapping(path="/results",params = "studentId")
    public List<Result> findResultsByStudentId(@RequestParam int studentId) {
        return resultService.findResultsByStudentId(studentId);
    }

    @GetMapping(path="/results",params = "examId")
    public List<Result> findResultsByExamId(@RequestParam String examId) {
        return resultService.findResultsByExamId(examId);
    }
}
