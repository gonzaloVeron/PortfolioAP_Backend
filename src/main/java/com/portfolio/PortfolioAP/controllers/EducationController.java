package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundException;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educations")
@CrossOrigin
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping(path = "/")
    @ResponseBody
    public List<Education> getAllEducations() {
        return educationService.findAll();
    }

    @PostMapping(path = "/")
    @ResponseBody
    public Education postEducation(@RequestBody EducationDTO dto) {
        return educationService.save(dto);
    }

    @PutMapping(path = "/{edu_id}")
    @ResponseBody
    public Education putEducation(@PathVariable int edu_id, @RequestBody EducationDTO dto) throws EducationNotFoundException {
        return educationService.update(edu_id, dto);
    }

}

