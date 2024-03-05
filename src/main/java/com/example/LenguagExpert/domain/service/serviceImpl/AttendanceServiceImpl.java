package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.AttendanceRepository;
import com.example.LenguagExpert.domain.service.service.AttendanceService;
import com.example.LenguagExpert.persistence.entity.Attendance;
import com.example.LenguagExpert.persistence.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;


    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository){
        this.attendanceRepository= attendanceRepository;
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long attendanceId) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
        if(optionalAttendance.isPresent()){
            return optionalAttendance.get();
        }else {
            throw new Error("Attendance id not found "+attendanceId);
        }
    }

    @Override
    public void saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendance.getId());

        if (optionalAttendance.isPresent()) {
            Attendance attendanceToUpdate = optionalAttendance.get();
            attendanceToUpdate.setDate(attendance.getDate());
            attendanceToUpdate.setClass_id(attendance.getClass_id());
            attendanceToUpdate.setStudent(attendance.getStudent());
            attendanceToUpdate.setStatus(attendance.getStatus());

            attendanceRepository.save(attendanceToUpdate);
            System.out.println("Attendance Updated");
        } else {
            throw new Error("Attendance ID not found " + attendance.getId());

        }
    }
}
