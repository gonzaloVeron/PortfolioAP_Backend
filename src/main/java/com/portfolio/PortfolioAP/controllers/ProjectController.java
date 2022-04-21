package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.dto.ProjectDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.ProjectNotfoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.Project;
import com.portfolio.PortfolioAP.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/jwt")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/")
    @ResponseBody
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @PostMapping(path = "/")
    @ResponseBody
    public Project postProject(HttpServletRequest request, @RequestBody ProjectDTO dto) throws UserNotFoundException {
        int user_id = (int)request.getAttribute("user_id");
        return this.projectService.save(user_id, dto);
    }

    @PutMapping(path = "/{proj_id}")
    @ResponseBody
    public Project putProject(@PathVariable int proj_id, @RequestBody ProjectDTO dto) throws ProjectNotfoundException {
        return this.projectService.update(proj_id, dto);
    }

    @DeleteMapping(path = "/{proj_id}")
    public void deleteProject(@PathVariable int proj_id){
        this.projectService.deleteById(proj_id);
    }

}
