package com.example.somalirestaurantbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        try {
            Path imagePath = Paths.get("uploads/images/", fileName);
            byte[] imageBytes = Files.readAllBytes(imagePath);

            return ResponseEntity.ok()
                    .header("Content-Type", Files.probeContentType(imagePath))
                    .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
