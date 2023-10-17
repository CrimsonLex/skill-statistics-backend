package com.backend.skillstatisticsbackend.service.impl;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.ResourceRepository;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.TopicService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    ResourceRepository resourceRepository;


    @Override
    public Topic saveTopic(Topic topic){
        return getTopicRepository().save(topic);
    }
    @Override
    public List<Topic> getAllTopics() {
        return getTopicRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TopicDTO> getTenTopicsDTO(){

        List<TopicDTO> topicDTOs = new ArrayList<>();
        List<Topic> topics = topicRepository.getTopTenTopics();

        for (Topic topic : topics) {
            TopicDTO topicDTO = mapTopicToDTO(topic);
            topicDTOs.add(topicDTO);
        }

        return topicDTOs;
    }
    public TopicDTO mapTopicToDTO(Topic topic) {

        int topicId = topic.getTopicId();
        String topicName = topic.getTopicName();
        int resourceCount = topic.getCountResources();

        return new TopicDTO(topicId, topicName, resourceCount);
    }

}
