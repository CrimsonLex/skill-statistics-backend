package com.backend.skillstatisticsbackend.service.impl;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.ResourceRepository;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.ResourceService;
import com.backend.skillstatisticsbackend.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TopicServiceImpl implements TopicService {


    TopicRepository topicRepository;

    ResourceRepository resourceRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository tR, ResourceRepository rS){
        topicRepository= tR;
        resourceRepository=rS;
    }


    @Override
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }
    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    @Transactional
    public List<TopicDTO> getTenTopics(){
        List<Object[]> topics = topicRepository.topTenTopics();
        List<TopicDTO> topicDTOList = new ArrayList<>();
        for (Object[] result : topics) {
            TopicDTO topicDTO= mapTopicToDTO(result);
            topicDTOList.add(topicDTO);

        }

        System.out.println(topics.get(0).toString());


//        for (Topic topic : topics) {
//
//            System.out.println("Aqui estoy dentro del service");
//            System.out.println(topic.getTopicName());
////            topic.getResources().forEach(e->{
////                System.out.println(e.getResourceName());
////            });
//            TopicDTO topicDTO = mapTopicToDTO(topic);
//            topicDTOList.add(topicDTO);
//        }

        return topicDTOList;
    }
    public TopicDTO mapTopicToDTO(Object[] result) {

        int topicId = (int) result[0];
        String topicName = (String) result[1];
        BigInteger resourceCount = (BigInteger)result[3];
        return new TopicDTO(topicId, topicName, resourceCount);
    }
}
