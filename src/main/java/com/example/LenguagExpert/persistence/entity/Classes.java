package com.example.LenguagExpert.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "class")
public class Classes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "class_name", nullable = false)
  private String className;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "teacher_id", nullable = false)
  private Teacher teacher;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "classroom_id", nullable = false)
  private Classroom classroom;

  @Column(name = "schedule", nullable = false)
  private String schedule;

  @Temporal(TemporalType.DATE)
  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "end_date", nullable = false)
  private Date endDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "topic_id", nullable = false)
  private Topic topic_id;

  public Classes() {
  }

  public Classes(Long id, String className, Teacher teacher, Classroom classroom, String schedule, Date startDate, Date endDate, Topic topic_id) {
    this.id = id;
    this.className = className;
    this.teacher = teacher;
    this.classroom = classroom;
    this.schedule = schedule;
    this.startDate = startDate;
    this.endDate = endDate;
    this.topic_id = topic_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Classroom getClassroom() {
    return classroom;
  }

  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Topic getTopic_id() {
    return topic_id;
  }

  public void setTopic_id(Topic topic_id) {
    this.topic_id = topic_id;
  }
}
