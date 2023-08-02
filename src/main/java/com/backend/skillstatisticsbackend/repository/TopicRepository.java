package com.backend.skillstatisticsbackend.repository;

import com.backend.skillstatisticsbackend.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
