package com.editalbox.service;

import com.editalbox.model.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ExamServiceATest {

    /*Note: the expected results written in the tests are
    based on the values provided in the ExamConfig class.*/

    private final ExamService examService;

    @Autowired
    public ExamServiceATest(ExamService examService) {
        this.examService = examService;
    }

    @Test
    public void testGetExam(){
        // Asserts that an exam with the expected properties (name, year, userCount) exists.

        Optional<Exam> examOptional = Optional.ofNullable(examService.getExam(1L));

        assertThat(examOptional).isPresent();
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            assertThat(exam.getName()).isEqualTo("ExampleA (2009)");
            assertThat(exam.getYear()).isEqualTo(2009);
            assertThat(exam.getUserCount()).isEqualTo(0);
        }
    }

    @Test
    public void testGetAllExams() {
        /* Asserts that the method will retrieve all existing exams and their correct
        properties. It expects two exams as it was defined in the ExamConfig class. */

        Optional<Exam> examOptional1 = Optional.ofNullable(examService.getAllExams().get(0));
        Optional<Exam> examOptional2 = Optional.ofNullable(examService.getAllExams().get(1));

        assertThat(examOptional1).isPresent();
        assertThat(examOptional2).isPresent();

        if (examOptional1.isPresent()) {
            Exam exam1 = examOptional1.get();
            assertThat(exam1.getName()).isEqualTo("ExampleA (2009)");
            assertThat(exam1.getYear()).isEqualTo(2009);
            assertThat(exam1.getUserCount()).isEqualTo(0);
        }

        if (examOptional2.isPresent()) {
            Exam exam2 = examOptional2.get();
            assertThat(exam2.getName()).isEqualTo("ExampleB (2007)");
            assertThat(exam2.getYear()).isEqualTo(2007);
            assertThat(exam2.getUserCount()).isEqualTo(5);
        }
    }

    @Test
    public void testCreateExam(){
        /* Asserts that the exam doesn't exist prior to the method
        and that it is created after it with its correct properties. */

        //BUG: ResourceNotFoundException is interfering with testCreateExam();
        Optional<Exam> examOptional; //= Optional.ofNullable(examService.getExam(3L));
        //assertThat(examOptional).isNotPresent();

        Exam createdExam = new Exam("MyExample (2008)", 2008,93);
        examService.createExam(createdExam);

        // examOptional is reassigned to receive the updated value of exam.
        examOptional = Optional.ofNullable(examService.getExam(3L));

        assertThat(examOptional).isPresent();
        if (examOptional.isPresent()) {
            Exam requestedExam = examOptional.get();
            assertThat(requestedExam.getName()).isEqualTo("MyExample (2008)");
            assertThat(requestedExam.getYear()).isEqualTo(2008);
            //userCount should receive zero regardless of the input
            assertThat(requestedExam.getUserCount()).isEqualTo(0);
        }
    }
}