package com.example.LenguagExpert.web.properties;

import com.example.LenguagExpert.domain.service.service.ClassesService;
import com.example.LenguagExpert.domain.service.service.ClassroomService;
import com.example.LenguagExpert.persistence.entity.Classes;
import com.example.LenguagExpert.persistence.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }
    @GetMapping
    public List<Classroom> getAllClassroom() {
        return classroomService.getAllClassroom();
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping
    public Classroom saveClassroom(@RequestBody Classroom classroom) {
        return classroomService.saveClassroom(classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}
