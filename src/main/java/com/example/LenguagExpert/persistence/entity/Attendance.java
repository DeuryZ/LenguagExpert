package com.example.LenguagExpert.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", nullable = false)
    private Classes classes_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status", length = 20)
    private String status;


    public Attendance() {
    }


    public Attendance(Long id, Classes classes_id, Student student, LocalDate date, String status) {
        this.id = id;
        this.classes_id = classes_id;
        this.student = student;
        this.date = date;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classes getClass_id() {
        return classes_id;
    }

    public void setClass_id(Classes classes_id) {
        this.classes_id = classes_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", class_id=" + classes_id +
                ", student=" + student +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

}
