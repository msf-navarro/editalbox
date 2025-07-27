//package site.Spring;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Table
//public class Content {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long contentId; //Primary Key
//    private String text;
//    private Boolean isCompleted;
//    private LocalDate completionDate;
//
//    public Content() {
//    }
//
//    public Content(String text,
//                   Boolean isCompleted,
//                   LocalDate completionDate) {
//        this.text = text;
//        this.isCompleted = isCompleted;
//        this.completionDate = completionDate;
//    }
//
//    public Long getContentId() {
//        return contentId;
//    }
//
//    public void setContentId(Long contentId) {
//        this.contentId = contentId;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public Boolean getCompleted() {
//        return isCompleted;
//    }
//
//    public void setCompleted(Boolean completed) {
//        isCompleted = completed;
//    }
//
//    public LocalDate getCompletionDate() {
//        return completionDate;
//    }
//
//    public void setCompletionDate(LocalDate completionDate) {
//        this.completionDate = completionDate;
//    }
//}