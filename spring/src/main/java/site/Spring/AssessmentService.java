package site.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    AssessmentRepository assessmentRepository;

    @Autowired
    AssessmentService(AssessmentRepository assessmentRepository){
        this.assessmentRepository = assessmentRepository;
    }

    public void gelAllExams(){
        assessmentRepository.findAll();
    }
}
