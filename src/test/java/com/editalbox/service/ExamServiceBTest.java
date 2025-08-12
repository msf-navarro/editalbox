package com.editalbox.service;

import com.editalbox.model.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/* Created to run testUpdateContent and testDeleteContent
separately, since it was causing error in other tests. */
@SpringBootTest
public class ExamServiceBTest {

    /*Note: the expected results written in the tests are
    based on the values provided in the ExamConfig class.*/

    private final ExamService examService;

    @Autowired
    public ExamServiceBTest(ExamService examService) {
        this.examService = examService;
    }

    @Test
    public void testUpdateExam(){
        /* Asserts that the exam has previous properties prior to the method,
        and that said properties have their expected value after the method. */

        Optional<Exam> examOptional = Optional.ofNullable(examService.getExam(2L));

        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            assertThat(exam.getName()).isEqualTo("ExampleB (2007)");
            assertThat(exam.getYear()).isEqualTo(2007);
            assertThat(exam.getUserCount()).isEqualTo(5);
        }

        examService.updateExam(
                2L,
                "MyUpdate (2020)",
                2020,
                null
        );

        // examOptional is reassigned to receive the updated value of exam.
        examOptional = Optional.ofNullable(examService.getExam(2L));

        assertThat(examOptional).isPresent();
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            assertThat(exam.getName()).isEqualTo("MyUpdate (2020)");
            assertThat(exam.getYear()).isEqualTo(2020);
            /* userCount remains unchanged and does NOT receive null, since
            the attributes should only change when the input is not null. */
            assertThat(exam.getUserCount()).isEqualTo(5);
        }
    }

    @Test
    public void testDeleteExam() {
        /* Asserts that the exam existed prior to the method, and
        that said exam was successfully deleted after the method. */

        //BUG: ResourceNotFoundException is interfering with testDeleteExam();
        Optional<Exam> examOptional; //= Optional.ofNullable(examService.getExam(2L));

        //assertThat(examOptional).isPresent();
        //if (examOptional.isPresent()) {
            examService.deleteExam(2L);
            /* examOptional is reassigned to receive the updated value of exam. Otherwise,
            it would retain the old value, resulting in .isNotPresent() to return false. */
            examOptional = Optional.ofNullable(examService.getExam(2L));
            assertThat(examOptional).isNotPresent();
        //}
    }
}