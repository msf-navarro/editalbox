package com.editalbox.service;

import com.editalbox.model.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ExamServiceTest {

    /*Note: the expected results written in the tests are
    based on the values provided in the ExamConfig class.*/

    private final ExamService examService;

    @Autowired
    public ExamServiceTest(ExamService examService) {
        this.examService = examService;
    }

    @Test
    public void testGetExam(){

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

        Exam createdExam = new Exam("MyExample (2008)", 2008,93);
        examService.createExam(createdExam);

        Optional<Exam> examOptional = Optional.ofNullable(examService.getExam(3L));

        assertThat(examOptional).isPresent();
        if (examOptional.isPresent()) {
            Exam requestedExam = examOptional.get();
            assertThat(requestedExam.getName()).isEqualTo("MyExample (2008)");
            assertThat(requestedExam.getYear()).isEqualTo(2008);
            assertThat(requestedExam.getUserCount()).isEqualTo(93);
        }
    }

    @Test
    public void testUpdateExam(){

        examService.updateExam(
                2L,
                "MyUpdate (2020)",
                2020,
                null
        );

        Optional<Exam> examOptional = Optional.ofNullable(examService.getExam(2L));

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

        Optional<Exam> examOptional = Optional.ofNullable(examService.getExam(2L));

        assertThat(examOptional).isPresent();
        if (examOptional.isPresent()) {
            examService.deleteExam(2L);
            //Returning the wrong value; Should NOT be present.
            assertThat(examOptional).isNotPresent();
            /* When asserting the userCount, it is true for 5,
            confirming that it was indeed not deleted. */
        }
    }
}