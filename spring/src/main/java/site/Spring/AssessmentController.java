package site.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessmentController {

    AssessmentService assessmentService;

    @Autowired
    AssessmentController(AssessmentService assessmentService){
        this.assessmentService = assessmentService;
    }

    @GetMapping
    public void getAllExams(){
        assessmentService.gelAllExams();
    }
}
