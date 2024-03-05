package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Long attendanceId);
    void saveAttendance(Attendance attendance);
    void deleteAttendance(Long attendanceId);
    void updateAttendance(Attendance attendance);
}
