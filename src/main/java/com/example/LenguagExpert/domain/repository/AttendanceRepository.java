package com.example.LenguagExpert.domain.repository;

import com.example.LenguagExpert.persistence.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {}
