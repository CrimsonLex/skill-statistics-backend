package com.backend.skillstatisticsbackend.repository;

import com.backend.skillstatisticsbackend.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {


}
