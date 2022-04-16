package com.portfolio.PortfolioAP.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
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
    public User findById(int id) {
        //this.validateId(id);

        return this.userRepository.findById(id).get();
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

    @Transactional
    public User findByEmailAndPassword(String email, String password) {
        //this.validateEmailAndPassword(email, password);
        return this.userRepository.findByEmailAndPassword(email, password).get();
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

    private void validateEmailAndPassword(String email, String password) throws MissingDataException {
        if(email == null || password == null){
            throw new MissingDataException("Faltan datos del usuario");
        }
    }
     */

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

    public String createJWT(String username) {
        String token = null;
        try {
            Date expireDate = new Date(2022, 4, 30);
            Algorithm algorithm = Algorithm.HMAC256(env.getProperty("jwtSecret"));
            token = JWT.create().withExpiresAt(expireDate).withSubject(username).withIssuer("Portfolio_api_v1").sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }

    public DecodedJWT verifyJWT(String token){
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(env.getProperty("jwtSecret"));
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Portfolio_api_v1")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
            System.out.println(jwt.getPayload());
        } catch (TokenExpiredException exception){
            //Invalid signature/claims
            System.out.println("a");
            System.out.println(jwt);
        }
        return jwt;
    }

}
