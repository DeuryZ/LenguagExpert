package com.example.LenguagExpert.web.properties;

import com.example.LenguagExpert.domain.service.service.ClassesService;
import com.example.LenguagExpert.persistence.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassesController {
    private final ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService){
        this.classesService = classesService;
    }
    @GetMapping
    public List<Classes> getAllClasses() {
        return classesService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Classes getClassById(@PathVariable Long id) {
        return classesService.getClassById(id);
    }

    @PostMapping
    public Classes saveClass(@RequestBody Classes classes) {
        return classesService.saveClass(classes);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classesService.deleteClass(id);
    }

}
