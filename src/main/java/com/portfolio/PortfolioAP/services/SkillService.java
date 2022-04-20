package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

}
