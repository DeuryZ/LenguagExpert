package com.example.LenguagExpert.domain.repository;

import com.example.LenguagExpert.persistence.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
