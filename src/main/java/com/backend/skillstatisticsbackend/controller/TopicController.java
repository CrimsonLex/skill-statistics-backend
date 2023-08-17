package com.backend.skillstatisticsbackend.controller;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.ResourceRepository;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.TopicService;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {


    private TopicRepository topicRepository;
    @Autowired
    private TopicServiceImpl topicService;
    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/getAll")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }


    public String addTopic(@RequestBody Topic topic){
        topicService.saveTopic(topic);
        return "New topic added succesfully";

    }
    @GetMapping("/getTenTopicsDTO")
    public List<TopicDTO> getTenTopicsDTO(){
        return topicService.getTenTopicsDTO();
    }


}
