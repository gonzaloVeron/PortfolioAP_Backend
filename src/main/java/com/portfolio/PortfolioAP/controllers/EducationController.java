package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/educations")
@CrossOrigin
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping(path = "/")
    public Education postUser(@RequestBody EducationDTO dto) {
        return educationService.save(dto);
    }

}

