package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.ProjectDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.ProjectNotfoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Project;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Project save(int user_id, ProjectDTO dto) throws UserNotFoundException {
        User userFound = this.userService.findById(user_id);
        Project project = new Project(dto.getTitle(), dto.getDescription(), dto.getUrl(), userFound);
        return this.projectRepository.save(project);
    }

    @Transactional
    public Project update(int project_id, ProjectDTO dto) throws ProjectNotfoundException {
        Project projectFound = this.projectRepository.findById(project_id).get();
        this.verifyProjectExistence(projectFound);
        projectFound.setTitle(dto.getTitle());
        projectFound.setDescription(dto.getDescription());
        projectFound.setUrl(dto.getUrl());
        return this.projectRepository.save(projectFound);
    }

    @Transactional
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Transactional
    public void deleteById(int id) {
        this.projectRepository.deleteById(id);
    }

    private void verifyProjectExistence(Project project) throws ProjectNotfoundException {
        if(project == null){
            throw new ProjectNotfoundException("The requested project was not found");
        }
    }
}
