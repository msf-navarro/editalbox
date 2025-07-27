//package site.Spring;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Table
//public class Subject {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long subjectId; //Primary Key
//    private Long contentId; //Foreign Key
//    private String name;
//    private Boolean isCompleted;
//    private LocalDate completionDate;
//
//    public Subject() {
//    }
//
//    public Subject(Long foreignKey,
//                   String name,
//                   Boolean isCompleted,
//                   LocalDate completionDate) {
//        this.contentId = foreignKey;
//        this.name = name;
//        this.isCompleted = isCompleted;
//        this.completionDate = completionDate;
//    }
//
//    public Long getSubjectId() {
//        return subjectId;
//    }
//
//    public void setSubjectId(Long subjectId) {
//        this.subjectId = subjectId;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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