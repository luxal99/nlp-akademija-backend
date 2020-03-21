package com.example.demo.service;

import com.example.demo.entity.ImageTable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public ResponseEntity.BodyBuilder uploadImage(MultipartFile file);
    public ImageTable getImage(String imageName);
}
