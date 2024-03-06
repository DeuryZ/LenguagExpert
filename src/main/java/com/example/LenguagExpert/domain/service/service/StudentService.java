package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    void insertSpecialActivity(Long specialActivityId, Long studentId);
}
