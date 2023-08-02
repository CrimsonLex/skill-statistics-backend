package com.backend.skillstatisticsbackend.service.impl;

import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;



    @Override
    public List<Topic> getAllTopics() {
        return null;
    }
}
