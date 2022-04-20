package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;
}
