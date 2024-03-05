package com.example.LenguagExpert.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "special_activities")
public class SpecialActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private int id;

    @Column(name = "activity_name", length = 255)
    private String activityName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "organizer", length = 255)
    private String organizer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_special_activity",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_special_activity",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();

    // Constructor vacío
    public SpecialActivity() {
    }

    // Constructor con parámetros
    public SpecialActivity(String activityName, String description, LocalDate date, String location, String organizer) {
        this.activityName = activityName;
        this.description = description;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    // Método toString()
    @Override
    public String toString() {
        return "SpecialActivity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", organizer='" + organizer + '\'' +
                '}';
    }
}

