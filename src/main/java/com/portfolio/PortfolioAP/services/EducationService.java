package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.EducationDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.EducationNotFoundExceptionSupplier;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Education;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Education save(int user_id, EducationDTO dto) throws UserNotFoundException {
        User userFound = this.userService.findById(user_id);
        Education education = new Education(dto.getCareer(), dto.getAverage(), dto.getImage(), dto.getTitle(), dto.getInstitution(), dto.getStart_year(), dto.getEnd_year(), userFound);
        return this.educationRepository.save(education);
    }

    @Transactional
    public Education update(int edu_id, EducationDTO dto) throws EducationNotFoundException {
        Education education = this.educationRepository.findById(edu_id).orElseThrow(new EducationNotFoundExceptionSupplier());
        education.setImage(dto.getImage());
        education.setAverage(dto.getAverage());
        education.setCareer(dto.getCareer());
        education.setStart_year(dto.getStart_year());
        education.setEnd_year(dto.getEnd_year());
        education.setInstitution(dto.getInstitution());
        education.setTitle(dto.getTitle());
        return this.educationRepository.save(education);
    }

    @Transactional
    public Education patch(int edu_id, EducationDTO dto) throws EducationNotFoundException {
        Education education = this.educationRepository.findById(edu_id).orElseThrow(new EducationNotFoundExceptionSupplier());
        if(dto.getImage() != null){
            education.setImage(dto.getImage());
        }
        if(dto.getAverage() > -1){
            education.setAverage(dto.getAverage());
        }
        if(dto.getCareer() != null){
            education.setCareer(dto.getCareer());
        }
        if(dto.getStart_year() > -1){
            education.setStart_year(dto.getStart_year());
        }
        if(dto.getEnd_year() > -1){
            education.setEnd_year(dto.getEnd_year());
        }
        if(dto.getInstitution() != null){
            education.setInstitution(dto.getInstitution());
        }
        if(dto.getTitle() != null){
            education.setTitle(dto.getTitle());
        }
        return this.educationRepository.save(education);
    }

    @Transactional
    public Education findById(int id) throws EducationNotFoundException {
        return this.educationRepository.findById(id).orElseThrow(new EducationNotFoundExceptionSupplier());
    }

    @Transactional
    public List<Education> findAll(){
        return this.educationRepository.findAll();
    }

    @Transactional
    public void deleteById(int id){
        this.educationRepository.deleteById(id);
    }

}
