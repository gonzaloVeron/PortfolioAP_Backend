package com.portfolio.PortfolioAP.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        //try{
        return userService.findById(id);
        //}catch(NoSuchElementException | InvalidIdException e){
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        //}
    }

    @GetMapping(path = "/test/{token}")
    @ResponseBody
    public DecodedJWT test(@PathVariable String token) {
        //User u = userService.findById(3);
        return userService.verifyJWT(token);
        //return userService.createJWT("Gonzalo");
        //try{
        //return userService.findById(id);
        //}catch(NoSuchElementException | InvalidIdException e){
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        //}
    }

    @PostMapping(path = "/user")
    public void postUser(@RequestBody User user) {
        //try{
        userService.save(user, user.getPassword());
        //}catch (MissingDataException e){
        //    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        //}
    }

    @DeleteMapping("/user/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        //try{
        userService.deleteById(id);
        //}catch (NoSuchElementException | InvalidIdException e){
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        //}
    }

    //@PostMapping(path = "/login")
    //@ResponseBody
    //public User getUserByEmail(@RequestBody User user) {
        //try {
        //return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        //}catch (MissingDataException e){
        //    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        //}
    //}
}
