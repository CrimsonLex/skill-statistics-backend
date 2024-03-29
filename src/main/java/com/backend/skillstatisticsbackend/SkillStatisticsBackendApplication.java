package com.backend.skillstatisticsbackend;

import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.service.impl.TopicServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SkillStatisticsBackendApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext  = SpringApplication.run(SkillStatisticsBackendApplication.class, args);

		TopicServiceImpl topicService = configurableApplicationContext.getBean(TopicServiceImpl.class);

		Topic topicTest1 = new Topic("H2",1);
		Topic topicTest2 = new Topic("Spring",2);

		System.out.println("Empiezo a guardar resources");
		Resource resourceTest1 = new Resource("H2 Guide", "baeldung.com", topicTest1);
		Resource resourceTest2 = new Resource("H2 Profiles", "baeldung.com", topicTest1);
		topicTest1.addResource(resourceTest1);
		topicTest1.addResource(resourceTest2);

		topicTest1.getResources().forEach(x->{
			System.out.println(x.getResourceName() +", "+x.getResourceUrl() );
		});

		topicService.saveTopic(topicTest1);
		topicService.saveTopic(topicTest2);

		List<TopicDTO> topTenTopics = topicService.getTenTopicsDTO();
		topTenTopics.forEach(e->{
			System.out.println("name: "+e.getTopicName()+", resourcesNumber: " + e.getResourcesNumber() );
		});

	}

}
