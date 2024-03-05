package com.example.LenguagExpert.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "classroom_name", length = 255)
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "availability")
    private boolean availability;

    public Classroom() {
    }

    public Classroom(String name, int capacity, boolean availability) {
        this.name = name;
        this.capacity = capacity;
        this.availability = availability;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", availability=" + availability +
                '}';
    }
}
