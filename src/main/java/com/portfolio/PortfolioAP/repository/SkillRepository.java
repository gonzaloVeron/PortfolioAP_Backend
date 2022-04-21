package com.portfolio.PortfolioAP.repository;

import com.portfolio.PortfolioAP.models.Skill;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer>  {

    Optional<Skill> findById(Integer id);

    List<Skill> findAll();
}
