package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.SpecialActivityRepository;
import com.example.LenguagExpert.domain.repository.TeacherRepository;
import com.example.LenguagExpert.domain.service.service.TeacherService;
import com.example.LenguagExpert.persistence.entity.SpecialActivity;
import com.example.LenguagExpert.persistence.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SpecialActivityRepository specialActivityRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,SpecialActivityRepository specialActivityRepository){
        this.teacherRepository = teacherRepository;
        this.specialActivityRepository = specialActivityRepository;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if(optionalTeacher.isPresent()){
            return optionalTeacher.get();
        }else {
            throw new Error("Attendance id not found "+teacherId);
        }
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public void updateTeacher(Long id ,Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);

        if (optionalTeacher.isPresent()) {

            Teacher teacherToUpdate = optionalTeacher.get();

            teacherToUpdate.setFirstName(teacher.getFirstName());
            teacherToUpdate.setEmail(teacher.getEmail());
            teacherToUpdate.setAddress(teacher.getAddress());
            teacherToUpdate.setPhone(teacher.getPhone());
            teacherToUpdate.setLastName(teacher.getLastName());
            teacherToUpdate.setSpecialActivity(teacher.getSpecialActivity());

            teacherRepository.save(teacherToUpdate);
            System.out.println("Teacher Updated");
        } else {
            throw new Error("Teacher ID not found " + id);
        }
    }

    @Override
    @Transactional
    public void insertSpecialActivity(Long specialActivityId, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        SpecialActivity specialActivity = specialActivityRepository.findById(specialActivityId).orElse(null);

        if (teacher != null && specialActivity != null) {
            specialActivity.getTeachers().add(teacher);
            teacher.getSpecialActivity().add(specialActivity);
//            specialActivityRepository.save(specialActivity);
//            studentRepository.save(student);
        }
    }
}
