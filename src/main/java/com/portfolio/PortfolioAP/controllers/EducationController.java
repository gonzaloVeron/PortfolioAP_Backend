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
@RequestMapping("/api/v1/educations/jwt")
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
    public Education postEducation(HttpServletRequest request, @RequestBody EducationDTO dto) throws UserNotFoundException {
        int user_id = (int)request.getAttribute("user_id");
        return this.educationService.save(user_id, dto);
    }

    @PutMapping(path = "/{edu_id}")
    @ResponseBody
    public Education putEducation(@PathVariable int edu_id, @RequestBody EducationDTO dto) throws EducationNotFoundException {
        return this.educationService.update(edu_id, dto);
    }

    @DeleteMapping(path = "/{edu_id}")
    public void deleteEducation(@PathVariable int edu_id){
        this.educationService.deleteById(edu_id);
    }

}

