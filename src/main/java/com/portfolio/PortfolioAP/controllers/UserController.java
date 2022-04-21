package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.UserDTO;
import com.portfolio.PortfolioAP.dto.UserLoggedDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.InvalidCredentials;
import com.portfolio.PortfolioAP.errorHandler.exceptions.MissingDataException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.dto.UserCredentialsDTO;
import com.portfolio.PortfolioAP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/jwt/{user_id}")
    @ResponseBody
    public User getUserById(@PathVariable int user_id) throws UserNotFoundException {
        return this.userService.findById(user_id);
    }

    @PostMapping(path = "/jwt")
    @ResponseBody
    public User postUser(@RequestBody UserDTO dto) {
        return this.userService.save(dto);
    }

    @PutMapping(path = "/jwt/{user_id}")
    @ResponseBody
    public User putUser(@PathVariable int user_id, @RequestBody UserDTO dto) throws UserNotFoundException {
        return this.userService.updateUser(user_id, dto);
    }

    @DeleteMapping("/jwt/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        this.userService.deleteById(user_id);
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public UserLoggedDTO login(@RequestBody UserCredentialsDTO userCred) throws MissingDataException, InvalidCredentials {
        return this.userService.authenticate(userCred.getEmail(), userCred.getPassword());
    }

}
