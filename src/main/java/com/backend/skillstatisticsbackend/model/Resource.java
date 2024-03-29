package com.backend.skillstatisticsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Resource")

@Getter

public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;

    private String resourceName;

    private String resourceUrl;

    //Will this be unique ????? We think that we shouldn´t repeat topics

    @ManyToOne
    @JoinColumn(name = "topic_Id")
    @JsonIgnore
    private Topic topic;

    public Resource(String resourceName, String resourceUrl,Topic topic) {
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.topic = topic;

    }

}
