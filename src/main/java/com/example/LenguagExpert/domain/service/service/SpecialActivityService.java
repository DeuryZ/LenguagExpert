package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.SpecialActivity;

import java.util.List;

public interface SpecialActivityService {
    List<SpecialActivity> getAllSpecialActivities();
    SpecialActivity getSpecialActivityById(Long id);
    SpecialActivity saveSpecialActivity(SpecialActivity specialActivity);
    void updateSpecialActivity(Long id, SpecialActivity specialActivity);
    void deleteSpecialActivity(Long id);

}
