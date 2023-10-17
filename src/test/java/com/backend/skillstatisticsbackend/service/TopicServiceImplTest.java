package com.backend.skillstatisticsbackend.service;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.ResourceRepository;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Transactional
public class TopicServiceImplTest {

    @InjectMocks
    private TopicServiceImpl topicService;

    @Mock
    private TopicRepository topicRepository;

    @Mock
    private ResourceRepository resourceRepository;


    List<Topic> setUp1() {

        Topic topicTest1 = new Topic("H2",1);
        Topic topicTest2 = new Topic("Spring",2);

        Resource resourceTest1 = new Resource("H2 Guide", "baeldung.com", topicTest1);
        Resource resourceTest2 = new Resource("H2 Profiles", "baeldung.com", topicTest1);
        Resource resourceTest3 = new Resource("Spring guide", "officialSpring.com", topicTest2);
        topicTest1.addResource(resourceTest1);
        topicTest1.addResource(resourceTest2);
        topicTest2.addResource(resourceTest3);

        List<Topic> result =Arrays.asList(topicTest1,topicTest2);

        return result;


    }
    List<Topic> setUp2(){
        List<Topic> result = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            Topic topic = new Topic("Topic " + i,i+2);
            for (int j = 1; j <= i; j++) {
                Resource resource = new Resource("Resource " + j, "URL " + j, topic);
                topic.addResource(resource);
            }
            result.add(topic);
        }
        return result;
    }

     @Test
    void service_using_topTenTopics_butWithLessThanTenTopics() {

         List<Topic> mockTopics= setUp1();

         when(topicRepository.getTopTenTopics()).thenReturn(mockTopics);

        List<TopicDTO> topicsToTest= topicService.getTenTopicsDTO();


        assertAll(
                () -> assertEquals(2,topicsToTest.size()),

                () -> assertEquals("H2",topicsToTest.get(0).getTopicName()),

                () -> assertEquals(2,topicsToTest.get(0).getResourcesNumber())
        );

       verify(topicRepository).getTopTenTopics();
    }

    @Test
    void service_using_topTenTopics_butWithoutTopics() {

        List<TopicDTO> topicsToTest= topicService.getTenTopicsDTO();

        assertTrue(topicsToTest.isEmpty());
    }


    @Test
    void service_using_topTenTopics_withTenTopics() {
        // Create mock data for topics
        List<Topic> mockTopics = setUp2();

        when(topicRepository.getTopTenTopics()).thenReturn(mockTopics);

        List<TopicDTO> topicsToTest= topicService.getTenTopicsDTO();



        assertAll(
                () -> assertEquals(10,topicsToTest.size()),

                () -> assertEquals("Topic 10",topicsToTest.get(0).getTopicName()),

                () -> assertEquals(10,topicsToTest.get(0).getResourcesNumber())
        );





    }



}






