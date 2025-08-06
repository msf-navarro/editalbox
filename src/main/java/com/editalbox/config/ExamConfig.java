package com.editalbox.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.editalbox.model.Exam;
import com.editalbox.repository.ExamRepository;
import org.springframework.core.annotation.Order;

@Configuration
//Needs to run before ContentConfig,
//otherwise it leads to an exception:
//"not-null property references a null or transient value"
@Order(1)
public class ExamConfig implements CommandLineRunner {

    private final ExamRepository examRepository;

    @Autowired
    ExamConfig(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /* The following values are used for checks in
        the ExamServiceTest and the ContentServiceTest.
        Do NOT change them. */

        Exam examA = new Exam(
                "ExampleA (2009)",
                2009,
                0);
        examRepository.save(examA);

        /* The following values are used for checks in
        the ExamServiceTest and the ContentServiceTest.
        Do NOT change them. */

        Exam examB = new Exam(
                "ExampleB (2007)",
                2007,
                5);
        examRepository.save(examB);

    }
}