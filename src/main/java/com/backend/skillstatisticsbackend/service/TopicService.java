package com.backend.skillstatisticsbackend.service;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();
    Topic saveTopic(Topic topic);

    List<TopicDTO> getTenTopicsDTO();

}
