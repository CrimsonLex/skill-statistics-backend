package com.backend.skillstatisticsbackend.repository;


import com.backend.skillstatisticsbackend.dto.TopicDTO;
import com.backend.skillstatisticsbackend.model.Topic;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Objects;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

  @Query(value ="SELECT t.topic_id as topicId, t.topic_name as topicName, t.user_id as userid, COUNT(r.topic_id) as count_resources " +
          "FROM TOPIC t LEFT JOIN RESOURCE r ON t.topic_id = r.topic_id " +
          "GROUP BY t.topic_id, t.topic_name ORDER BY count_resources DESC LIMIT 10", nativeQuery = true)

  List<Topic> getTopTenTopics();

}
