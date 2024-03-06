package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.SpecialActivityRepository;
import com.example.LenguagExpert.domain.service.service.SpecialActivityService;
import com.example.LenguagExpert.persistence.entity.SpecialActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialActivityServiceImpl implements SpecialActivityService {

    private final SpecialActivityRepository specialActivityRepository;

    @Autowired
    public SpecialActivityServiceImpl(SpecialActivityRepository specialActivityRepository){
        this.specialActivityRepository = specialActivityRepository;
    }

    @Override
    public List<SpecialActivity> getAllSpecialActivities() {
        return specialActivityRepository.findAll();
    }

    @Override
    public SpecialActivity getSpecialActivityById(Long id) {
        Optional<SpecialActivity> optionalSpecialActivity = specialActivityRepository.findById(id);
        if(optionalSpecialActivity.isPresent()){
            return optionalSpecialActivity.get();
        }else {
            throw new Error("Special Activity ID not found " + id);
        }
    }

    @Override
    public SpecialActivity saveSpecialActivity(SpecialActivity specialActivity) {
        specialActivityRepository.save(specialActivity);
        return specialActivity;
    }

    @Override
    public void updateSpecialActivity(Long id, SpecialActivity specialActivity) {
        Optional<SpecialActivity> optionalSpecialActivity = specialActivityRepository.findById(id);
        if(optionalSpecialActivity.isPresent()){
            SpecialActivity updateSpecialActivity = optionalSpecialActivity.get();
            updateSpecialActivity.setActivityName(specialActivity.getActivityName());
            updateSpecialActivity.setDate(specialActivity.getDate());
            updateSpecialActivity.setDescription(specialActivity.getDescription());
            updateSpecialActivity.setLocation(specialActivity.getLocation());
            updateSpecialActivity.setOrganizer(specialActivity.getOrganizer());
            specialActivityRepository.save(updateSpecialActivity);
        }else {
            throw new Error("Special Activity ID not found " + id);
        }


    }

    @Override
    public void deleteSpecialActivity(Long id) {
        specialActivityRepository.deleteById(id);
    }
}
