package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> getAllClasses();
    Classes getClassById(Long classId);
    Classes saveClass(Classes classes);
    void deleteClass(Long classId);
    void updateClass(Classes classes);
}
