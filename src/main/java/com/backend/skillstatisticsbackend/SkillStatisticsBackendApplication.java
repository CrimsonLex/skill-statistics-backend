package com.backend.skillstatisticsbackend;

import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.model.Topic;
import com.backend.skillstatisticsbackend.repository.TopicRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SkillStatisticsBackendApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext  = SpringApplication.run(SkillStatisticsBackendApplication.class, args);

		TopicRepository topicRepository = configurableApplicationContext.getBean(TopicRepository.class);

		Topic topicTest1 = new Topic("H2");
		Topic topicTest2 = new Topic("Spring");

		Resource resourceTest1 = new Resource("H2 Guide", "baeldung.com", topicTest1);
		Resource resourceTest2 = new Resource("H2 Profiles", "baeldung.com", topicTest1);
		topicTest1.addResource(Optional.of(resourceTest1));
		topicTest1.addResource(Optional.of(resourceTest2));




		topicRepository.save(topicTest1);
		topicRepository.save(topicTest2);




	}

}
