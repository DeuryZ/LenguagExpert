package com.example.LenguagExpert.domain.repository;

import com.example.LenguagExpert.persistence.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
