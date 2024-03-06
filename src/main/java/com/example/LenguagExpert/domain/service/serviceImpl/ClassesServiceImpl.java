package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.ClassRepository;
import com.example.LenguagExpert.domain.service.service.ClassesService;
import com.example.LenguagExpert.persistence.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassesServiceImpl(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    @Override
    public List<Classes> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Classes getClassById(Long classId) {
        Optional<Classes> optionalClasses = classRepository.findById(classId);
        if(optionalClasses.isPresent()){
            return optionalClasses.get();
        }else {
            throw new Error("Class id not found "+classId);
        }
    }

    @Override
    public Classes saveClass(Classes classes) {
        classRepository.save(classes);
        return classes;
    }

    @Override
    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }

    @Override
    public void updateClass(Long id, Classes classes) {
        Optional<Classes> optionalClasses = classRepository.findById(id);
        if (optionalClasses.isPresent()){
            Classes classesToUpdate = optionalClasses.get();
            classesToUpdate.setClassName(classes.getClassName());
            classesToUpdate.setTeacher(classesToUpdate.getTeacher());
            classesToUpdate.setClassroom(classes.getClassroom());
            classesToUpdate.setSchedule(classes.getSchedule());
            classesToUpdate.setStartDate(classes.getStartDate());
            classesToUpdate.setEndDate(classes.getEndDate());
            classesToUpdate.setTopic_id(classes.getTopic_id());
            classRepository.save(classesToUpdate);
        }else{
            throw new Error("Attendance ID not found " + classes.getId());
        }
    }
}
