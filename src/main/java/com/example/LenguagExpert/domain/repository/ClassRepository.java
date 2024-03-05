package com.example.LenguagExpert.domain.repository;

import com.example.LenguagExpert.persistence.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classes, Long> {
}
