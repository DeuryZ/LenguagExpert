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

}
