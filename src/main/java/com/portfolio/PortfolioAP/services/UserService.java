package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.UserDTO;
import com.portfolio.PortfolioAP.dto.UserLoggedDTO;
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
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Environment env;

    @Autowired
    private JwtService jwtService;

    @Transactional
    public User save(UserDTO dto) {
        String encodedPassword = this.hashPassword(dto.getPassword());
        User user = new User(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getAbout_me(), dto.getEmployment(), dto.getBirth_date(), dto.getNationality(), dto.getProfile_img(), dto.getBackground_img());
        user.setPassword(encodedPassword);
        return this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(int user_id, UserDTO dto) throws UserNotFoundException {
        User user = this.userRepository.findById(user_id).get();
        this.validateUserExistence(user);
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setAbout_me(dto.getAbout_me());
        user.setBirth_date(dto.getBirth_date());
        user.setEmployment(dto.getEmployment());
        user.setNationality(dto.getNationality());
        user.setProfile_img(dto.getProfile_img());
        user.setBackground_img(dto.getBackground_img());
        return this.userRepository.save(user);
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
    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    @Transactional
    public UserLoggedDTO authenticate(String email, String password) throws MissingDataException, InvalidCredentials {
        this.validateEmailAndPassword(email, password);
        User userFound = this.userRepository.findByEmail(email).get();
        if(!this.matchPassword(password, userFound.getPassword())){
            throw new InvalidCredentials();
        }
        return new UserLoggedDTO(userFound, this.jwtService.create(userFound.getId()));
    }

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

    public String hashPassword(String password){
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
