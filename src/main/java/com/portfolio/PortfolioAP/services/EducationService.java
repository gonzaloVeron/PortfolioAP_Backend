package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundException;
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
    public Education update(int edu_id, EducationDTO dto) throws EducationNotFoundException {
        Education education = this.educationRepository.findById(edu_id).get();
        if(education == null){
            throw new EducationNotFoundException("The requested education was not found");
        }
        education.setImage(dto.getEducation().getImage());
        education.setAverage(dto.getEducation().getAverage());
        education.setCareer(dto.getEducation().getCareer());
        education.setStart_year(dto.getEducation().getStart_year());
        education.setEnd_year(dto.getEducation().getEnd_year());
        education.setInstitution(dto.getEducation().getInstitution());
        education.setTitle(dto.getEducation().getTitle());
        return this.educationRepository.save(education);
    }

    @Transactional
    public Education findById(int id) throws EducationNotFoundException {
        Education education = this.educationRepository.findById(id).get();
        if(education == null){
            throw new EducationNotFoundException("The requested education was not found");
        }
        return education;
    }

    @Transactional
    public List<Education> findAll(){
        return this.educationRepository.findAll();
    }

}
