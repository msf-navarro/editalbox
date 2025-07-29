package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    private final ExamService examService;

    @Autowired
    ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping(path = "/exams")
    public List<Exam> getAllExams() {
        return examService.gelAllExams();
    }

    @PostMapping(path = "/add_exam")
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }
}