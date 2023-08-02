package com.backend.skillstatisticsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Topic")

@Getter
@Setter
public class Topic{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    private String topicName;


    @OneToMany(
            mappedBy = "topic",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch= FetchType.LAZY
    )
    @JsonIgnore
    private List<Resource> topicResources;

    public Topic(String topicName) {
        this.topicName = topicName;
        topicResources = new ArrayList<>();
    }

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
