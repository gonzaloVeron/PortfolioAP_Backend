package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.ImageNameDTO;
import com.portfolio.PortfolioAP.dto.UserDTO;
import com.portfolio.PortfolioAP.dto.UserLoggedDTO;
import com.portfolio.PortfolioAP.errorHandler.exceptions.InvalidCredentials;
import com.portfolio.PortfolioAP.errorHandler.exceptions.MissingDataException;
import com.portfolio.PortfolioAP.errorHandler.exceptions.UserNotFoundException;
import com.portfolio.PortfolioAP.models.User;
import com.portfolio.PortfolioAP.dto.UserCredentialsDTO;
import com.portfolio.PortfolioAP.services.ImageService;
import com.portfolio.PortfolioAP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @GetMapping(path = "/{user_id}")
    @ResponseBody
    public User getUserById(@PathVariable int user_id) throws UserNotFoundException {
        return this.userService.findById(user_id);
    }

    @PostMapping(path = "/jwt")
    @ResponseBody
    public User postUser(@RequestBody UserDTO dto) {
        return this.userService.save(dto);
    }

    @PutMapping(path = "/jwt")
    @ResponseBody
    public User putUser(HttpServletRequest request, @RequestBody UserDTO dto) throws UserNotFoundException {
        int user_id = (int)request.getAttribute("user_id");
        return this.userService.updateUser(user_id, dto);
    }

    @PatchMapping(path = "/jwt")
    @ResponseBody
    public User patchUser(HttpServletRequest request, @RequestBody UserDTO dto) throws UserNotFoundException {
        int user_id = (int)request.getAttribute("user_id");
        return this.userService.patchUser(user_id, dto);
    }

    @DeleteMapping(path = "/jwt/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        this.userService.deleteById(user_id);
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public UserLoggedDTO login(@RequestBody UserCredentialsDTO userCred) throws MissingDataException, InvalidCredentials {
        return this.userService.authenticate(userCred.getEmail(), userCred.getPassword());
    }

    @PostMapping(path = "/jwt/img")
    @ResponseBody
    public ImageNameDTO uploadImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return this.imageService.upload(multipartFile);
    }

//    @PostMapping(path  = "/img")
//    @ResponseBody
//    public String uploadImage(@RequestParam("file") MultipartFile img){
//        Path completeRoute = null;
//        String imgAbsoluteRoute = null;
//        if(!img.isEmpty()){
//            Path imgDir = Paths.get("src//main//resources//images");
//            imgAbsoluteRoute = imgDir.toFile().getAbsolutePath();
//            try{
//                byte[] bytesImg = img.getBytes();
//                completeRoute = Paths.get(imgAbsoluteRoute + "//" + img.getOriginalFilename());
//                Files.write(completeRoute, bytesImg);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        return imgAbsoluteRoute;
//    }

}
