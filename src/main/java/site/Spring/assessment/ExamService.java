package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.support.PlaceholderResolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    @Autowired
    ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam getExam(Long examId) {
        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isPresent())
            return examOptional.get();
        else return null;
    }

    public List<Exam> gelAllExams() {
        return examRepository.findAll();
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

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
            examRepository.save(exam);
        }
    }

    public void deleteExam(Long examId) {
        if (examRepository.existsById(examId))
            examRepository.deleteById(examId);
    }
}