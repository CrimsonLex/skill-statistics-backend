package com.backend.skillstatisticsbackend.controller;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173/"})
@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicServiceImpl topicService;

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
