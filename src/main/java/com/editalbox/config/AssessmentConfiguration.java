//package com.editalbox.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import com.editalbox.model.Content;
//import com.editalbox.repository.ContentRepository;
//import com.editalbox.model.Exam;
//import com.editalbox.repository.ExamRepository;
//
//@Configuration
//public class AssessmentConfiguration implements CommandLineRunner {
//
//    private final ExamRepository examRepository;
//    private final ContentRepository contentRepository;
//
//    @Autowired
//    AssessmentConfiguration(ExamRepository examRepository,
//                            ContentRepository contentRepository) {
//        this.examRepository = examRepository;
//        this.contentRepository = contentRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Exam examA = new Exam(
//                "ExampleA (2009)",
//                2009,
//                0);
//        examRepository.save(examA);
//
//        Exam examB = new Exam(
//                "ExampleB (2007)",
//                2007,
//                0);
//        examRepository.save(examB);
//
//        Content contentA1 = new Content(
//                examA,
//                "statistics",
//                "simple probability");
//        contentRepository.save(contentA1);
//
//        Content contentA2 = new Content(
//                examA,
//                "statistics",
//                "conditional probability");
//        contentRepository.save(contentA2);
//
//        Content contentB1 = new Content(
//                examB,
//                "mathematics",
//                "linear algebra");
//        contentRepository.save(contentB1);
//    }
//}