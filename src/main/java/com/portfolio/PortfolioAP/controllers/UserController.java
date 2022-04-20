package com.portfolio.PortfolioAP.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.portfolio.PortfolioAP.errorHandler.HttpErrorException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.InvalidCredentials;
import com.portfolio.PortfolioAP.errorHandler.exceptions.MissingDataException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.models.UserCredentials;
import com.portfolio.PortfolioAP.services.JwtService;
import com.portfolio.PortfolioAP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/jwt/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userService.findById(id);
    }

    @PostMapping(path = "/jwt")
    public void postUser(@RequestBody User user) {
        userService.save(user, user.getPassword());
    }

    @DeleteMapping("/jwt/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public User login(@RequestBody UserCredentials userCred) throws MissingDataException, InvalidCredentials {
        return userService.authenticate(userCred.getEmail(), userCred.getPassword());
    }
}
