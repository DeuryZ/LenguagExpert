package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Long attendanceId);
    Attendance saveAttendance(Attendance attendance);
    void deleteAttendance(Long attendanceId);
    Attendance updateAttendance(Long id, Attendance attendance);
}
