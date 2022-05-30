package com.portfolio.PortfolioAP.services;

import com.portfolio.PortfolioAP.dto.UserDTO;
import com.portfolio.PortfolioAP.dto.UserLoggedDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.*;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.env.Environment;
import java.security.SecureRandom;
import java.util.List;
import java.util.function.Supplier;

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
//        this.validateUserExistence(user);
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
    public User patchUser(int user_id, UserDTO dto) throws UserNotFoundException {
        User userFound = this.userRepository.findById(user_id).orElseThrow(new UserNotFoundExceptionSupplier());
        if(dto.getEmail() != null){
            userFound.setEmail(dto.getEmail());
        }
        if(dto.getName() != null){
            userFound.setName(dto.getName());
        }
        if(dto.getSurname() != null){
            userFound.setSurname(dto.getSurname());
        }
        if(dto.getAbout_me() != null){
            userFound.setAbout_me(dto.getAbout_me());
        }
        if(dto.getBirth_date() != null){
            userFound.setBirth_date(dto.getBirth_date());
        }
        if(dto.getEmployment() != null){
            userFound.setEmployment(dto.getEmployment());
        }
        if(dto.getNationality() != null){
            userFound.setNationality(dto.getNationality());
        }
        if(dto.getProfile_img() != null){
            userFound.setProfile_img(dto.getProfile_img());
        }
        if(dto.getBackground_img() != null){
            userFound.setBackground_img(dto.getBackground_img());
        }
        return userFound;
    }

    @Transactional
    public User findById(int id) throws UserNotFoundException {
        return this.userRepository.findById(id).orElseThrow(new UserNotFoundExceptionSupplier());
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
        User userFound = this.userRepository.findByEmail(email).orElseThrow(new InvalidCredentialsSupplier());
        if(!this.matchPassword(password, userFound.getPassword())){
            throw new InvalidCredentials();
        }
        return new UserLoggedDTO(userFound, this.jwtService.create(userFound.getId()));
    }

    private void validateEmailAndPassword(String email, String password) throws MissingDataException {
        if(email == null || password == null){
            throw new MissingDataException("User missing data", 400);
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
