package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.AttendanceRepository;
import com.example.LenguagExpert.domain.service.service.AttendanceService;
import com.example.LenguagExpert.persistence.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Attendance saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
        return attendance;
    }

    @Override
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if (optionalAttendance.isPresent()) {

            Attendance attendanceToUpdate = optionalAttendance.get();
            attendanceToUpdate.setId(id);
            attendanceToUpdate.setDate(attendance.getDate());
            attendanceToUpdate.setClass_id(attendance.getClass_id());
            attendanceToUpdate.setStudent(attendance.getStudent());
            attendanceToUpdate.setStatus(attendance.getStatus());

            attendanceRepository.save(attendanceToUpdate);
            System.out.println("Attendance Updated");
        } else {
            throw new Error("Attendance ID not found " + attendance.getId());
        }
        return attendance;
    }
}
