package com.backend.skillstatisticsbackend.service;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TopicServiceImplTest {

    @InjectMocks
    private TopicServiceImpl topicService;

    @Mock
    private TopicRepository topicRepository;

    @Test
    public void testGetTopTenTopics() {
        List<Topic> mockTopics = createMockTopics(); // Create some mock topics
        //when(topicRepository.topTenTopics()).thenReturn(mockTopics);

        List<TopicDTO> result = topicService.getTenTopics();

        assertEquals(mockTopics.size(), result.size());
        // More assertions and verifications as needed...
    }

    private List<Topic> createMockTopics() {
        List<Topic> mockTopics = new ArrayList<>();



        // Create and add mock Topic entities
        Topic topic1 = new Topic("Topic 1");
        topic1.setTopicId(1); // Set the ID manually for testing
        topic1.setResources(Collections.singletonList(new Resource("Resource 1", "URL 1", topic1)));
        mockTopics.add(topic1);

        Topic topic2 = new Topic("Topic 2");
        topic2.setTopicId(2); // Set the ID manually for testing
        topic2.setResources(Collections.singletonList(new Resource("Resource 2", "URL 2", topic2)));
        mockTopics.add(topic2);

        // Add more mock topics as needed...

        return mockTopics;
    }

    public void setup1(){
        Topic topicTest1 = new Topic("H2",1);
        Topic topicTest2 = new Topic("Spring",2);

        Resource resourceTest1 = new Resource("H2 Guide", "baeldung.com", topicTest1);
        Resource resourceTest2 = new Resource("H2 Profiles", "baeldung.com", topicTest1);
        topicTest1.addResource(resourceTest1);
        topicTest1.addResource(resourceTest2);




        topicService.saveTopic(topicTest1);
        topicService.saveTopic(topicTest2);

    }
}