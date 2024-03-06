package com.example.LenguagExpert.domain.service.service;


import com.example.LenguagExpert.persistence.entity.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> getAllClassroom();
    Classroom getClassroomById(Long classroomId);
    Classroom saveClassroom(Classroom classroom);
    void deleteClassroom(Long classroomId);
    void updateClassroom(Long id, Classroom classroom);
}
