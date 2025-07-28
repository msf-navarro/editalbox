package site.Spring.assessment;

import jakarta.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //Primary Key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private String subject;
    private String text;

    //(Doesn't make sense in here. Will be on /users package)
    //private Boolean isChecked;
    //private LocalDate checkDate;

    public Content() {
    }

    public Content(Exam exam,
                   String subject,
                   String text){
        this.exam = exam;
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
}