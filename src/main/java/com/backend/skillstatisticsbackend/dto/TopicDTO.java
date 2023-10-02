package com.backend.skillstatisticsbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TopicDTO {

   int topicId;
   String topicName;
   int resourcesNumber;

   public TopicDTO(int topicId, String topicName, int resourcesNumber){
      this.topicId=topicId;
      this.topicName=topicName;
      this.resourcesNumber=resourcesNumber;
   }

}


