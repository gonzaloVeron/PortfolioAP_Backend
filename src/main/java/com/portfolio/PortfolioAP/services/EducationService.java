package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.EducationRepository;
import com.portfolio.PortfolioAP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Education save(EducationDTO dto) {
        User userFound = this.userRepository.findById(dto.getUser_id()).get();
        Education education = dto.getEducation();
        education.setImage("no_images.png");
        education.setUser(userFound);
        return this.educationRepository.save(education);
    }

    @Transactional
    public Education findById(int id) {
        return this.educationRepository.findById(id).get();
    }

    @Transactional
    public List<Education> findAll(){
        return this.educationRepository.findAll();
    }

}
