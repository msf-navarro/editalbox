package com.editalbox.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //Primary Key
    private String name;
    private Integer year;

    //The column is named this way by default
    //Still, this was added for later reference
    @Column(name = "user_count")
    private Integer userCount;

    //(Doesn't make sense in here. Will be on /users package)
    //private Boolean isChecked;
    //private LocalDate checkDate;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> contents = new ArrayList<>();

    public Exam() {
    }

    public Exam(String name,
                Integer year,
                Integer userCount) {
        this.name = name;
        this.year = year;
        this.userCount = userCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}