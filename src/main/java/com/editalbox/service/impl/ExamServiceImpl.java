package com.editalbox.service.impl;

import com.editalbox.exceptions.EmptyInputException;
import com.editalbox.exceptions.ResourceNotFoundException;
import com.editalbox.model.Exam;
import com.editalbox.repository.ExamRepository;
import com.editalbox.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    @Autowired
    ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam getExam(Long examId) {
        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isPresent()) {
            System.out.printf("\n>Retrieved Exam with id \"%d\"<\n", examId);
            return examOptional.get();
        } else throw new ResourceNotFoundException("Exam", examId);
    }

    public List<Exam> getAllExams() {
        System.out.println("\n>Retrieved all Exams<\n");
        return examRepository.findAll();
    }

    public Exam createExam(Exam exam) {
        if (exam.getName().isEmpty()) {
            throw new EmptyInputException("name");
        } else if (exam.getYear() == null) {
            throw new EmptyInputException("year");
        } else {
            exam.setUserCount(0);
            /* Fetches how many exams there are and adds
            one to find what the next id used will be.
            The reason for this is that retrieving
            exam.getId() will return "null" */
            Integer examId = examRepository.findAll().size() + 1;
            System.out.printf("\n>Created Exam with id \"%d\"<\n", examId);
            return examRepository.save(exam);
        }
    }

    //need to add ways to avoid invalid inputs
    public void updateExam(Long examId,
                           String examName,
                           Integer examYear,
                           Integer examUserCount) {
        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            if (examName != null)
                exam.setName(examName);
            if (examYear != null)
                exam.setYear(examYear);
            if (examUserCount != null)
                exam.setUserCount(examUserCount);
            System.out.printf("\n>Updated Exam with id \"%d\"<\n", examId);
            examRepository.save(exam);
        }
    }

    public void deleteExam(Long examId) {
        if (examRepository.existsById(examId)) {
            System.out.printf("\n>Deleted Exam with id \"%d\"<\n", examId);
            examRepository.deleteById(examId);
        }
    }
}