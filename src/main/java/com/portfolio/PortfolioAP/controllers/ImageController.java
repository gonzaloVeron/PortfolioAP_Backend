package com.portfolio.PortfolioAP.controllers;

import com.portfolio.PortfolioAP.dto.ImageNameDTO;
import com.portfolio.PortfolioAP.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(path = "/jwt/img")
    @ResponseBody
    public ImageNameDTO uploadUserImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return this.imageService.upload(multipartFile);
    }
}
