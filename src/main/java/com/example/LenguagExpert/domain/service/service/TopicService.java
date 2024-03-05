package com.example.LenguagExpert.domain.service.service;

import com.example.LenguagExpert.persistence.entity.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic();
    Topic getTopicById(Long topicId);
    Topic saveTopic(Topic topic);
    void deleteTopic(Long topicId);
    void updateTopic(Topic topic);
}
