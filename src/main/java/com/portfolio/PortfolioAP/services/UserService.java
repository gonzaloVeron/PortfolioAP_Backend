package com.portfolio.PortfolioAP.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.portfolio.PortfolioAP.errorHandler.exceptions.InvalidCredentials;
import com.portfolio.PortfolioAP.errorHandler.exceptions.MissingDataException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.env.Environment;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Environment env;

    @Transactional
    public User save(User model, String password) {
        //this.validateUser(model);
        String encodedPassword = this.hashPassword(password);
        model.setPassword(encodedPassword);
        return this.userRepository.save(model);
    }

    @Transactional
    public User findById(int id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).get();
        this.validateUserExistence(user);
        return user;
    }

    @Transactional
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        //this.validateId(id);
        this.userRepository.deleteById(id);
    }

    /*
    private void validateId(Integer id) throws InvalidIdException {
        if(id <= 0){
            throw new InvalidIdException("El id no existe");
        }
    }

    private void validateUser(User user) throws MissingDataException {
        if(user.getName() == null ||
                user.getSurname() == null ||
                user.getNick() == null ||
                user.getPassword() == null ||
                user.getEmail() == null){
            throw new MissingDataException("Faltan datos del usuario");
        }
    }
    */

    private void validateUserExistence(User user) throws UserNotFoundException {
        if(user == null){
            throw new UserNotFoundException("The requested user was not found");
        }
    }

    private void validateEmailAndPassword(String email, String password) throws MissingDataException {
        if(email == null || password == null){
            throw new MissingDataException("Faltan datos del usuario", 400);
        }
    }

    @Transactional
    public User authenticate(String email, String password) throws MissingDataException, InvalidCredentials {
        this.validateEmailAndPassword(email, password);
        User userFound = this.userRepository.findByEmail(email).get();
        if(this.matchPassword(password, userFound.getPassword())){
            throw new InvalidCredentials();
        }
        return userFound;
    }

    private String hashPassword(String password){
        int strength = Integer.parseInt(env.getProperty("passHashSecret"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        return encodedPassword;
    }

    private boolean matchPassword(String rawPassword, String encodedPassword){
        int strength = Integer.parseInt(env.getProperty("passHashSecret"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

}
