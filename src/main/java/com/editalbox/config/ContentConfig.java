package com.editalbox.config;

import com.editalbox.model.Content;
import com.editalbox.repository.ContentRepository;
import com.editalbox.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//Needs to run after ExamConfig,
//otherwise it leads to an exception:
//"not-null property references a null or transient value"
@Order(2)
public class ContentConfig implements CommandLineRunner {

    private final ExamRepository examRepository;
    private final ContentRepository contentRepository;

    @Autowired
    ContentConfig(ExamRepository examRepository,
                  ContentRepository contentRepository) {
        this.examRepository = examRepository;
        this.contentRepository = contentRepository;
    }

    public void linkContentToExam(Content content){
        Long contentExamId = content.getExamId();
        if (examRepository.existsById(contentExamId))
            content.setExam(
                    examRepository.getReferenceById(contentExamId)
            );
    }

    @Override
    public void run(String... args) throws Exception {

        Content contentA1 = new Content(
                1L,
                "statistics",
                "simple probability");
        linkContentToExam(contentA1);
        contentRepository.save(contentA1);

        Content contentA2 = new Content(
                1L,
                "statistics",
                "conditional probability");
        linkContentToExam(contentA2);
        contentRepository.save(contentA2);

        Content contentB1 = new Content(
                2L,
                "mathematics",
                "linear algebra");
        linkContentToExam(contentB1);
        contentRepository.save(contentB1);
    }
}