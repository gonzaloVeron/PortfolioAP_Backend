package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/educations")
@CrossOrigin
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping(path = "")
    @ResponseBody
    public List<Education> getAllEducations() {
        return educationService.findAll();
    }

    @GetMapping(path = "/{edu_id}")
    public Education getById(@PathVariable int edu_id) throws EducationNotFoundException {
        return this.educationService.findById(edu_id);
    }

    @PostMapping(path = "/jwt")
    @ResponseBody
    public Education postEducation(HttpServletRequest request, @RequestBody EducationDTO dto) throws UserNotFoundException {
        int user_id = (int)request.getAttribute("user_id");
        return this.educationService.save(user_id, dto);
    }

    @PutMapping(path = "/jwt/{edu_id}")
    @ResponseBody
    public Education putEducation(@PathVariable int edu_id, @RequestBody EducationDTO dto) throws EducationNotFoundException {
        return this.educationService.update(edu_id, dto);
    }

    @PatchMapping(path = "/jwt/{edu_id}")
    @ResponseBody
    public Education patchEducation(@PathVariable int edu_id, @RequestBody EducationDTO dto) throws EducationNotFoundException {
        return this.educationService.patch(edu_id, dto);
    }

    @DeleteMapping(path = "/jwt/{edu_id}")
    public void deleteEducation(@PathVariable int edu_id){
        this.educationService.deleteById(edu_id);
    }

}

