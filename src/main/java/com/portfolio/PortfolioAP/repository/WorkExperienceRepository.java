package com.portfolio.PortfolioAP.repository;

import com.portfolio.PortfolioAP.models.WorkExperience;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface WorkExperienceRepository extends CrudRepository<WorkExperience, Integer> {

    Optional<WorkExperience> findById(Integer id);

    List<WorkExperience> findAll();

}
