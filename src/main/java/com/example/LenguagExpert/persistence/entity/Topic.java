package com.example.LenguagExpert.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicID;
    private String topicName;
    private int semester;
    private int week;
    private String description;

    public Topic(){

    }

    public Topic(Long topicID, String topicName, int semester, int week, String description){
        this.topicID = topicID;
        this.topicName = topicName;
        this.semester = semester;
        this.week = week;
        this.description = description;
    }

    public Long getTopicID() {
        return topicID;
    }

    public void setTopicID(Long topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicID=" + topicID +
                ", topicName='" + topicName + '\'' +
                ", semester=" + semester +
                ", week=" + week +
                ", description='" + description + '\'' +
                '}';
    }
}
