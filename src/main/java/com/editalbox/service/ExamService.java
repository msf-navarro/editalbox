package com.editalbox.service;

import com.editalbox.model.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    public Exam getExam(Long examId);

    public List<Exam> gelAllExams();

    public Exam createExam(Exam exam);

    public void updateExam(Long examId,
                           String examName,
                           Integer examYear,
                           Integer examUserCount);

    public void deleteExam(Long examId);
}