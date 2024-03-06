package com.example.LenguagExpert.domain.service.service;



import com.example.LenguagExpert.persistence.entity.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long teacherId);
    Teacher saveTeacher(Teacher teacher);
    void deleteTeacher(Long teacherId);
    void updateTeacher(Long id, Teacher teacher);

    @Transactional
    void insertSpecialActivity(Long specialActivityId, Long studentId);
}
