package com.example.LenguagExpert.domain.repository;

import com.example.LenguagExpert.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
