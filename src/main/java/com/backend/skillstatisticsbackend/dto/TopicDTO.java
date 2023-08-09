package com.backend.skillstatisticsbackend.dto;

import com.backend.skillstatisticsbackend.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter


public class TopicDTO {
   int topicId;
   String topicName;
   BigInteger resourcesNumber;

   public TopicDTO(){

   }
   public TopicDTO(int topicId, String topicName, BigInteger resourceSize){
      this.topicId=topicId;
      this.topicName=topicName;
      //System.out.println(resources);
      resourcesNumber=resourceSize;
      //resourcesNumber= resources.size();

   }


}


