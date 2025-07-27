package site.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AssessmentConfiguration implements CommandLineRunner{

    private final AssessmentRepository assessmentRepository;

    @Autowired
    AssessmentConfiguration(AssessmentRepository assessmentRepository){
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Exam testExam = new Exam(
                "Example",
                LocalDate.now(),
                LocalDate.of(2009,1,1), /*, DateTimeFormatter.ofPattern("yyyy")*/
                true,
                0);
        assessmentRepository.save(testExam);
    }
}
