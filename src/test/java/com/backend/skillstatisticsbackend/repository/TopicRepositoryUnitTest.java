package com.backend.skillstatisticsbackend.repository;


import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.model.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJpaTest
public class TopicRepositoryUnitTest {


    @Autowired
    private TopicRepository topicRepository;

    void setUp1(){
        Topic topicTest1 = new Topic("H2",1);
        Topic topicTest2 = new Topic("Spring",2);

        Resource resourceTest1 = new Resource("H2 Guide", "baeldung.com", topicTest1);
        Resource resourceTest2 = new Resource("H2 Profiles", "baeldung.com", topicTest1);
        Resource resourceTest3 = new Resource("Spring guide", "officialSpring.com", topicTest2);
        topicTest1.addResource(resourceTest1);
        topicTest1.addResource(resourceTest2);
        topicTest2.addResource(resourceTest3);

        topicRepository.save(topicTest2);
        topicRepository.save(topicTest1);


    }
    void setUp2(){
        for (int i = 1; i <= 10; i++) {
            Topic topic = new Topic("Topic " + i,i+2);
            for (int j = 1; j <= i; j++) {
                Resource resource = new Resource("Resource " + j, "URL " + j, topic);
                topic.addResource(resource);
            }
            topicRepository.save(topic);
        }
    }

    @Test
    void topTenTopicsDTO_with_less_than_ten_Topics(){
        setUp1();
        int fixedLimit = 10;
        PageRequest pageRequest = PageRequest.of(0, fixedLimit);
        List<TopicDTO> topicsToTest=topicRepository.topTenTopicsDTO(pageRequest);

        assertEquals(2,topicsToTest.size());

        assertEquals("H2",topicsToTest.get(0).getTopicName());

        assertEquals(2,topicsToTest.get(0).getResourcesNumber());



    }


    @Test
    void topTenTopicsDTO_without_topics(){

        int fixedLimit = 10;
        PageRequest pageRequest = PageRequest.of(0, fixedLimit);
        List<TopicDTO> topicsToTest=topicRepository.topTenTopicsDTO(pageRequest);

        assertTrue(topicsToTest.isEmpty());

    }

    @Test
    void topTenTopicsDTO_with_more_than_10_topics(){


        setUp1();
        setUp2();

        int fixedLimit = 10;
        PageRequest pageRequest = PageRequest.of(0, fixedLimit);
        List<TopicDTO> topicsToTest=topicRepository.topTenTopicsDTO(pageRequest);


        assertEquals(10, topicsToTest.size());
        assertEquals(10,topicsToTest.get(0).getResourcesNumber());

    }


}