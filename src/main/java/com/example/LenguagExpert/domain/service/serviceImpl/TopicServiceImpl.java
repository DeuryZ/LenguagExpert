package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.TopicRepository;
import com.example.LenguagExpert.domain.service.service.TopicService;
import com.example.LenguagExpert.persistence.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(Long topicId) {
        Optional<Topic> optionalTopic = topicRepository.findById(topicId);
        return optionalTopic.orElse(null);
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }

    @Override
    public void updateTopic(Topic topic) {
        Optional<Topic> optionalTopic = topicRepository.findById(topic.getTopicID());

        if (optionalTopic.isPresent()) {
            Topic topicToUpdate = optionalTopic.get();
            topicToUpdate.setTopicName(topic.getTopicName());
            topicToUpdate.setDescription(topic.getDescription());
            topicToUpdate.setSemester(topic.getSemester());
            topicToUpdate.setWeek(topic.getWeek());

            topicRepository.save(topicToUpdate);
            System.out.println("Topic Updated");
        } else {
            throw new Error("Topic ID not found " + topic.getTopicID());

        }
    }

}
