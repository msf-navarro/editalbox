package site.Spring;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long examId; //Primary Key
    private String name;
    private LocalDate createdAt;
    private LocalDate examYear;
    private Boolean isPastExam;
    //(Doesn't make sense in here. Will be on /users package)
    //private Boolean isChecked;
    //private LocalDate checkDate;
    private Integer userCount;

    public Exam() {
    }

    public Exam(String name,
                LocalDate creationDate,
                LocalDate examYear,
                Boolean isPastExam,
                Integer userCount) {
        this.name = name;
        this.createdAt = creationDate;
        this.examYear = examYear;
        this.isPastExam = isPastExam;
        this.userCount = userCount;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getExamYear() {
        return examYear;
    }

    public void setExamYear(LocalDate examYear) {
        this.examYear = examYear;
    }

    public Boolean getPastExam() {
        return isPastExam;
    }

    public void setPastExam(Boolean pastExam) {
        isPastExam = pastExam;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}