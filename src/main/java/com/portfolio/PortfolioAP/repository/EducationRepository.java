package com.portfolio.PortfolioAP.repository;

import com.portfolio.PortfolioAP.models.Education;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface EducationRepository extends CrudRepository<Education, Integer> {

    Optional<Education> findById(Integer id);

    List<Education> findAll();

}
