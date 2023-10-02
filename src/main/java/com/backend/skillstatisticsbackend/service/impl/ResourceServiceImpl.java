package com.backend.skillstatisticsbackend.service.impl;

import com.backend.skillstatisticsbackend.model.Resource;
import com.backend.skillstatisticsbackend.repository.ResourceRepository;
import com.backend.skillstatisticsbackend.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        super();
        this.resourceRepository = resourceRepository;
    }
    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
