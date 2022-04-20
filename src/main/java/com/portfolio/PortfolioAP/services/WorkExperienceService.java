package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.dto.WorkExperienceDTO;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.models.WorkExperience;
import com.portfolio.PortfolioAP.repository.UserRepository;
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
    private UserRepository userRepository;

    @Transactional
    public WorkExperience save(WorkExperienceDTO dto) {
        User userFound = this.userRepository.findById(dto.getUser_id()).get();
        WorkExperience experience = dto.getExperience();
        experience.setUser(userFound);
        return this.workExperienceRepository.save(experience);
    }

    @Transactional
    public WorkExperience findById(int id) {
        return this.workExperienceRepository.findById(id).get();
    }

    @Transactional
    public List<WorkExperience> findAll(){
        return this.workExperienceRepository.findAll();
    }

}
