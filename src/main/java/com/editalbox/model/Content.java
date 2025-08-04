package com.editalbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //Primary Key

    @ManyToOne(fetch = FetchType.LAZY)
    //Foreign Key
    @JoinColumn(name = "exam_id", nullable = false)
    //Used to avoid errors when serializing FetchType.LAZY
    @JsonIgnore
    private Exam exam;

    //Used for retrieving the examId in GET without EAGER.
    //Transient for not being added in the database as a column.
    //As a Transient, it needs to be loaded with a method.
    //That is: Content method loadExam().
    @Transient
    private Long examId; //Foreign Key for HTTP requests
    @Transient
    private String examName; //exam name for HTTP requests

    private String subject;
    private String text;

    //(Doesn't make sense in here. Will be on /users package)
    //private Boolean isChecked;
    //private LocalDate checkDate;

    public Content() {
    }

    public Content(Exam exam,
                   String subject,
                   String text) {
        this.exam = exam;
        this.subject = subject;
        this.text = text;
    }

    public Content(Long examId,
                   String subject,
                   String text) {
        this.examId = examId;
        this.subject = subject;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @PostLoad
    public void loadExam() {
        if (exam != null) {
            examId = exam.getId();
            examName = exam.getName();
        }
    }
}
