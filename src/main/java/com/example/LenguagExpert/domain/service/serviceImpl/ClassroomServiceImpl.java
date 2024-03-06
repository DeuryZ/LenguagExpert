package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.ClassroomRepository;
import com.example.LenguagExpert.domain.service.service.ClassroomService;
import com.example.LenguagExpert.persistence.entity.Classroom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository){
        this.classroomRepository=classroomRepository;
    }

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long classroomId) {
        Optional<Classroom> optionalClassroom = classroomRepository.findById(classroomId);
        if(optionalClassroom.isPresent()){
            return optionalClassroom.get();
        }else{
            throw new Error("Classroom id not found "+classroomId);
        }
    }

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
        return classroom;
    }

    @Override
    public void deleteClassroom(Long classroomId) {
        classroomRepository.deleteById(classroomId);
    }

    @Override
    public void updateClassroom(Long id, Classroom classroom) {
        Optional<Classroom> optionalClassroom = classroomRepository.findById(id);
        if(optionalClassroom.isPresent()){
            Classroom classroomToUpdate = optionalClassroom.get();

            classroomToUpdate.setCapacity(classroom.getCapacity());
            classroomToUpdate.setAvailability(classroom.isAvailability());
            classroomToUpdate.setName(classroom.getName());

            classroomRepository.save(classroomToUpdate);
        }else {
            throw new Error("Classroom ID not found " + id);
        }
    }
}
