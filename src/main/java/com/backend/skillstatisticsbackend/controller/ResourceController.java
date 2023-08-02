package com.backend.skillstatisticsbackend.controller;

import com.backend.skillstatisticsbackend.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {
    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        super();
        this.resourceService = resourceService;
    }
    @GetMapping("/resources")
    public String listResources(Model model){

        model.addAttribute("resources", resourceService.getAllResources());
        return "resources ";



    }
}
