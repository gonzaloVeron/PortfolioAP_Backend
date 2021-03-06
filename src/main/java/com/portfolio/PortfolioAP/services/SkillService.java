package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.SkillDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.SkillNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.SkillNotFoundExceptionSupplier;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Skill;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public Skill save(int user_id, SkillDTO dto) throws UserNotFoundException {
        User userFound = this.userService.findById(user_id);
        Skill skill = new Skill(dto.getName(), dto.getLevel(), userFound);
        return this.skillRepository.save(skill);
    }

    @Transactional
    public Skill update(int skill_id, SkillDTO dto) throws SkillNotFoundException {
        Skill skillFound = this.skillRepository.findById(skill_id).orElseThrow(new SkillNotFoundExceptionSupplier());
        skillFound.setName(dto.getName());
        skillFound.setLevel(dto.getLevel());
        return this.skillRepository.save(skillFound);
    }

    @Transactional
    public Skill patch(int skill_id, SkillDTO dto) throws SkillNotFoundException {
        Skill skillFound = this.skillRepository.findById(skill_id).orElseThrow(new SkillNotFoundExceptionSupplier());
        if(dto.getName() != null){
            skillFound.setName(dto.getName());
        }
        if(dto.getLevel() > -1){
            skillFound.setLevel(dto.getLevel());
        }
        return this.skillRepository.save(skillFound);
    }

    @Transactional
    public List<Skill> getAll(){
        return this.skillRepository.findAll();
    }

    @Transactional
    public Skill getById(int skill_id) throws SkillNotFoundException {
        return this.skillRepository.findById(skill_id).orElseThrow(new SkillNotFoundExceptionSupplier());
    }

    @Transactional
    public void delete(int skill_id){
        this.skillRepository.deleteById(skill_id);
    }

}
