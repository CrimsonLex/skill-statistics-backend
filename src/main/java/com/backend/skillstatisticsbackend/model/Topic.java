package com.backend.skillstatisticsbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Topic")
@NoArgsConstructor
@Getter
@Setter
@NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t")
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

    private List<Resource> resources;

    @Column(name="count_resources")
    private int countResources;
    @Column(name = "user_id", nullable = false)
    private String userId;

    public Topic(String topicName, String userId) {
        this.topicName = topicName;
        this.userId = userId;
        resources = new ArrayList<>();
        countResources=0;
    }
    public Topic(String topicName) {
        this.topicName = topicName;
        resources = new ArrayList<>();
    }

    public Resource addResource(Resource resource){

       Resource addedSuccesfully = null;

        if(resource == null){
            return addedSuccesfully;
        }

        getResources().add(resource);
        addedSuccesfully= resource;
        this.countResources =numberOfResources();
        // Falta la validación y el agregarlo.
        return addedSuccesfully;

    }
    public int numberOfResources(){
        int numOfResources = 0;
        if(!resources.isEmpty()){
            return this.resources.size();
        }
        return numOfResources;
    }

}
