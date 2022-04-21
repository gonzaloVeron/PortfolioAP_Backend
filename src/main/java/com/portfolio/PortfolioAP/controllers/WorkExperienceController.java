package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.UserDTO;
import com.portfolio.PortfolioAP.dto.WorkExperienceDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.WorkExperienceNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.models.WorkExperience;
import com.portfolio.PortfolioAP.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/experiences/jwt")
@CrossOrigin
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping(path = "/")
    @ResponseBody
    public List<WorkExperience> getAllExperiences() {
        return this.workExperienceService.getAll();
    }

    @PostMapping(path = "/")
    @ResponseBody
    public WorkExperience postExperience(HttpServletRequest request, @RequestBody WorkExperienceDTO dto) throws UserNotFoundException {
        return this.workExperienceService.save((int)request.getAttribute("user_id"), dto);
    }

    @PutMapping(path = "/{exp_id}")
    @ResponseBody
    public WorkExperience putExperience(@PathVariable int exp_id, @RequestBody WorkExperienceDTO dto) throws WorkExperienceNotFoundException {
        return this.workExperienceService.update(exp_id, dto);
    }

    @DeleteMapping("/{exp_id}")
    public void deleteExperience(@PathVariable int exp_id) {
        this.workExperienceService.delete(exp_id);
    }
}
