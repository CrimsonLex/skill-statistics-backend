package com.backend.skillstatisticsbackend.controller;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.service.TopicService;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(TopicController.class)
public class TopicControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int randomServerPort;
    List<TopicDTO> setUp2(){
        List<TopicDTO> mockedTopics = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            TopicDTO topic = new TopicDTO(i , "Topic " + i,i);
            // Add any necessary resources to the topic
            mockedTopics.add(topic);
        }

        return mockedTopics;
    }
    List<TopicDTO> setUp1() {

        List<TopicDTO> mockedTopics = new ArrayList<>();

        TopicDTO topicTest1 = new TopicDTO(1, "H2", 1);
        TopicDTO topicTest2 = new TopicDTO(2, "Spring", 2);


        mockedTopics.add(topicTest1);
        mockedTopics.add(topicTest2);

        return mockedTopics;

    }

    @Test
    void return_less_than_ten_topics() throws Exception {
        List<TopicDTO> buildingTestTopics=  setUp1();

        when(topicService.getTenTopicsDTO()).thenReturn(buildingTestTopics);

        mockMvc.perform(get("api/v1/topics/getTenTopicsDTO"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id",is(1)));


    }







}
