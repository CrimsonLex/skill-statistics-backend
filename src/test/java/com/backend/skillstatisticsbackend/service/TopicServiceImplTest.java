package com.backend.skillstatisticsbackend.service;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
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
    private TopicServiceImpl topicService = new TopicServiceImpl();

    @Mock
    private TopicRepository topicRepository;

    @Mock
    private ResourceRepository resourceRepository;


    List<TopicDTO> setUp1() {

        List<TopicDTO> mockedTopics = new ArrayList<>();

        TopicDTO topicTest1 = new TopicDTO(1, "H2", 1);
        TopicDTO topicTest2 = new TopicDTO(2, "Spring", 2);



        mockedTopics.add(topicTest1);
        mockedTopics.add(topicTest2);

        return mockedTopics;



    }
    List<TopicDTO> setUp2(){
        List<TopicDTO> mockedTopics = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            TopicDTO topic = new TopicDTO(i , "Topic " + i,i);
            // Add any necessary resources to the topic
            mockedTopics.add(topic);
        }

        return mockedTopics;
    }

    //Preguntar aqui sobre los mocks, si meto 11 ej, como se hace mock no prueba el funcionamiento del metodo y pasan los 11, cuando en ejecución normal si los limita a 10
    @Test
    void service_using_topTenTopics_butWithLessThanTenTopics() {

        List<TopicDTO> mockedTopics =setUp1();
        when(topicRepository.topTenTopicsDTO(PageRequest.of(0, 10))).thenReturn(mockedTopics);
        List<TopicDTO> topicsToTest= topicService.getTenTopicsDTO();



        assertEquals(2,topicsToTest.size());

        assertEquals("H2",topicsToTest.get(0).getTopicName());

        assertEquals(1,topicsToTest.get(0).getResourcesNumber());
       verify(topicRepository).topTenTopicsDTO(PageRequest.of(0, 10));
    }

    @Test
    void service_using_topTenTopics_butWithoutTopics() {



        List<TopicDTO> mockedTopics=Collections.emptyList();
        when(topicRepository.topTenTopicsDTO(PageRequest.of(0, 10))).thenReturn(mockedTopics);

        List<TopicDTO> topicsToTest= topicService.getTenTopicsDTO();

        assertTrue(topicsToTest.isEmpty());



        assertTrue(topicsToTest.isEmpty());
    }


    @Test
    void testGetTenTopicsDTO() {
        // Create mock data for topics
        List<TopicDTO> mockTopics = setUp2();


        // Configure the mock topicRepository behavior
        when(topicRepository.topTenTopicsDTO(PageRequest.of(0, 10))).thenReturn(mockTopics);

        // Call the method to be tested
        List<TopicDTO> result = topicService.getTenTopicsDTO();

        // Assert the result
        assertEquals(10, result.size());
        verify(topicRepository).topTenTopicsDTO(PageRequest.of(0, 10));

        // Add more assertions if needed
    }

    // Write more test methods for other scenarios

}






