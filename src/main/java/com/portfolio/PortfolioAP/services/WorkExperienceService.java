package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.WorkExperienceDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.WorkExperienceNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.models.WorkExperience;
import com.portfolio.PortfolioAP.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public WorkExperience save(int user_id, WorkExperienceDTO dto) throws UserNotFoundException {
        User userFound = this.userService.findById(user_id);
        WorkExperience experience = new WorkExperience(dto.getDescription(), dto.getTitle(), dto.getCity(), dto.getCompany_name(), dto.getStart_date(), dto.getEnd_date(), userFound);
        return this.workExperienceRepository.save(experience);
    }

    @Transactional
    public WorkExperience update(int exp_id, WorkExperienceDTO dto) throws WorkExperienceNotFoundException {
        WorkExperience experienceFound = this.workExperienceRepository.findById(exp_id).get();
        this.verifyExperienceExistence(experienceFound);
        experienceFound.setDescription(dto.getDescription());
        experienceFound.setCity(dto.getCity());
        experienceFound.setCompany_name(dto.getCompany_name());
        experienceFound.setTitle(dto.getTitle());
        experienceFound.setStart_date(dto.getStart_date());
        experienceFound.setEnd_date(dto.getEnd_date());
        return this.workExperienceRepository.save(experienceFound);
    }

    @Transactional
    public void delete(int exp_id){
        this.workExperienceRepository.deleteById(exp_id);
    }

    @Transactional
    public List<WorkExperience> getAll(){
        return this.workExperienceRepository.findAll();
    }

    private void verifyExperienceExistence(WorkExperience experience) throws WorkExperienceNotFoundException {
        if(experience == null){
            throw new WorkExperienceNotFoundException("The requested work experience was not found");
        }
    }

}
