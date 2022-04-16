package com.portfolio.PortfolioAP.repository;

import com.portfolio.PortfolioAP.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findById(Integer id);

    List<User> findAll();

    //@Query(value = "SELECT * FROM USERS u WHERE u.EMAIL = :email AND u.PASSWORD = :password", nativeQuery = true)
    //User findByEmailAndPassword(@Param("email") String userEmail, @Param("password") String userPassword);

    Optional<User> findByEmailAndPassword(String email, String password);

}
