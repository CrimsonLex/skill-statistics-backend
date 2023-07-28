package com.backend.skillstatisticsbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic{

    @Id
    private int topicId;

    private String topicName;

    private List<Resource> topicResources;

    public boolean addResource(Optional<Resource> resource){

        boolean addedSuccesfully = false;

        if(resource.isPresent()){
            addedSuccesfully= topicResources.add(resource.get());
        }

        // Falta la validación y el agregarlo.

        return addedSuccesfully;

    }
    public int numberOfResources(){
        int numOfResources = 0;
        if(!topicResources.isEmpty()){
            return topicResources.size();
        }
        //Falta hacer o llamar el metodo para mostrar cuantos resources hay
        return numOfResources;
    }





}
