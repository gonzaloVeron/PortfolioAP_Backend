package com.portfolio.PortfolioAP.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.portfolio.PortfolioAP.dto.ImageNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    private Environment env;

    public ImageNameDTO upload(MultipartFile multipartFile) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        String bucketName = env.getProperty("firebase.bucket.name");
        String projectId = env.getProperty("firebase.project.id");
        FileInputStream serviceAccount =
                new FileInputStream(s + env.getProperty("firebase.credentials"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        String uuid = UUID.randomUUID().toString();

        Storage storage = storageOptions.getService();
        BlobId blobId = BlobId.of(bucketName, uuid);

        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(multipartFile.getContentType()).build();

        Blob blob = storage.create(blobInfo, multipartFile.getBytes());

        ImageNameDTO dto = new ImageNameDTO(uuid);

        return dto;
    }

}
