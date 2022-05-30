package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.SkillDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.SkillNotFoundException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.Skill;
import com.portfolio.PortfolioAP.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping(path = "/jwt")
    @ResponseBody
    public Skill postSkill(HttpServletRequest request, @RequestBody SkillDTO dto) throws UserNotFoundException {
        return this.skillService.save((int) request.getAttribute("user_id"), dto);
    }

    @GetMapping(path = "")
    @ResponseBody
    public List<Skill> getAllSkill(){
        return this.skillService.getAll();
    }

    @PutMapping(path = "/jwt/{skill_id}")
    @ResponseBody
    public Skill putSkill(@PathVariable int skill_id, @RequestBody SkillDTO dto) throws SkillNotFoundException {
        return this.skillService.update(skill_id, dto);
    }

    @DeleteMapping(path = "/jwt/{skill_id}")
    public void deleteSkill(@PathVariable int skill_id){
        this.skillService.delete(skill_id);
    }

}
