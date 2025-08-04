package com.editalbox.controller;

import com.editalbox.service.ExamService;
import com.editalbox.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    private final ExamService examService;

    @Autowired
    ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping(path = "/exams/{id}")
    public Exam getExam(@PathVariable("id") Long examId) {
        return examService.getExam(examId);
    }

    @GetMapping(path = "/exams")
    public List<Exam> getAllExams() {
        return examService.gelAllExams();
    }

    @PostMapping(path = "/admin/resources/exams")
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @PutMapping(path = "/admin/resources/exams/{id}")
    public void updateExam(@PathVariable("id") Long examId,
                           @RequestParam(required = false, value = "name") String examName,
                           @RequestParam(required = false, value = "year") Integer examYear,
                           @RequestParam(required = false, value = "user_count") Integer examUserCount){
        examService.updateExam(examId, examName, examYear, examUserCount);
    }

    @DeleteMapping(path = "/admin/resources/exams/{id}")
    public void deleteExam(@PathVariable("id") Long examId){
        examService.deleteExam(examId);
    }
}