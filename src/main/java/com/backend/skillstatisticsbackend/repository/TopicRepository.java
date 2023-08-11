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


  @Query(value ="SELECT t.topic_id as topicId, t.topic_name as topicName, t.user_id as userid, COUNT(r.topic_id) as resources " +
          "FROM TOPIC t LEFT JOIN RESOURCE r ON t.topic_id = r.topic_id " +
          "GROUP BY t.topic_id, t.topic_name ORDER BY resources DESC", nativeQuery = true)

    //@Query(value ="SELECT t.topic_id as id, t.topic_name as name, COUNT(r.topic_id) as resources,t.user_id as user_id FROM TOPIC t LEFT JOIN RESOURCE r ON t.topic_id = r.topic_id GROUP BY t.topic_id, t.topic_name ORDER BY resources DESC;",nativeQuery = true)
    List<Object[]> topTenTopics();


  @Query(value= "SELECT NEW com.backend.skillstatisticsbackend.dto.TopicDTO(t.topicId, t.topicName, COUNT(r)) " +
          "FROM Topic t LEFT JOIN t.resources r " +
          "GROUP BY t.topicId, t.topicName " +
          "ORDER BY COUNT(r) DESC ")

    //@Query(value ="SELECT t.topic_id as id, t.topic_name as name, COUNT(r.topic_id) as resources,t.user_id as user_id FROM TOPIC t LEFT JOIN RESOURCE r ON t.topic_id = r.topic_id GROUP BY t.topic_id, t.topic_name ORDER BY resources DESC;",nativeQuery = true)
  List<TopicDTO> topTenTopicsDTO(PageRequest pageable);

}
