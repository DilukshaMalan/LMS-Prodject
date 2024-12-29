package com.example.malan.service;

import com.example.malan.data.Result;
import com.example.malan.data.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }



    public List<Result> findResultsByStudentId(int studentId) {
        return resultRepository.findResultsByStudentId(studentId);
    }

    public List<Result> findResultsByExamId(String examId) {
        return resultRepository.findResultsByExamId(examId);
    }

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public Result getResultById(int id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.orElse(null);
    }

    public void deleteResultById(int id) {
        resultRepository.deleteById(id);
    }

    public Result updateResult(Result result) {
        return resultRepository.save(result);
    }
}
