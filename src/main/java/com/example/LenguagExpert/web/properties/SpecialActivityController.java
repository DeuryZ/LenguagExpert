package com.example.LenguagExpert.web.properties;

import com.example.LenguagExpert.domain.service.service.ClassroomService;
import com.example.LenguagExpert.domain.service.service.SpecialActivityService;
import com.example.LenguagExpert.persistence.entity.Classroom;
import com.example.LenguagExpert.persistence.entity.SpecialActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class SpecialActivityController {
    private final SpecialActivityService specialActivityService;

    @Autowired
    public SpecialActivityController(SpecialActivityService specialActivityService){
        this.specialActivityService = specialActivityService;
    }
    @GetMapping
    public List<SpecialActivity> getAllSpecialActivity() {
        return specialActivityService.getAllSpecialActivities();
    }

    @GetMapping("/{id}")
    public SpecialActivity getSpecialActivityById(@PathVariable Long id) {
        return specialActivityService.getSpecialActivityById(id);
    }

    @PostMapping
    public SpecialActivity saveSpecialActivity(@RequestBody SpecialActivity specialActivity) {
        return specialActivityService.saveSpecialActivity(specialActivity);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialActivity(@PathVariable Long id) {
        specialActivityService.deleteSpecialActivity(id);
    }
}
