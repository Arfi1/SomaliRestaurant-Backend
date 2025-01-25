package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.MenuItem;
import com.example.somalirestaurantbackend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MenuItemService {

    // Base path hvor billederne gemmes
    // Inject upload directory path from application.properties
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Integer id) {
        return menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public MenuItem saveMenuItemWithImage(MenuItem menuItem, MultipartFile file) {
        // Resolve the upload path
        Path uploadPath = Paths.get(uploadDir);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Create the directory if it doesn't exist
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory: " + e.getMessage());
        }

        // Validate file name
        String originalFileName = file.getOriginalFilename();
        if (originalFileName.isEmpty()) {
            throw new RuntimeException("Invalid file. File name is empty.");
        }

        // Sanitize file name
        String sanitizedFileName = originalFileName.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
        String fileName = menuItem.getName().replaceAll(" ", "_") + "_" + sanitizedFileName;
        Path filePath = uploadPath.resolve(fileName);

        // Save file
        try {
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }

        // Update imageUrl in MenuItem
        String imageUrl = uploadDir + "/" + fileName;
        menuItem.setImageUrl(imageUrl);

        // Save menu item
        return menuItemRepository.save(menuItem);
    }
/*
    public String uploadImage(Integer menuItemId, MultipartFile file) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id: " + menuItemId));

        // Resolve the upload path
        Path uploadPath = Paths.get(uploadDir);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory: " + e.getMessage());
        }

        // Validate file name
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null || originalFileName.isEmpty()) {
            throw new RuntimeException("Invalid file. File name is empty.");
        }

        // Save file with a unique name
        String fileName = menuItemId + "_" + originalFileName;
        Path filePath = uploadPath.resolve(fileName);
        try {
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }

        // Update imageUrl in MenuItem
        String imageUrl = uploadDir + "/" + fileName;
        menuItem.setImageUrl(imageUrl);
        menuItemRepository.save(menuItem);

        return imageUrl;
    }

*/

    public MenuItem updateMenuItem(Integer id, MenuItem menuItem) {
        MenuItem existingItem = getMenuItemById(id);
        existingItem.setName(menuItem.getName());
        existingItem.setDescription(menuItem.getDescription());
        existingItem.setPrice(menuItem.getPrice());
        existingItem.setAvailable(menuItem.getAvailable());
        existingItem.setCategory(menuItem.getCategory());
        return menuItemRepository.save(existingItem);
    }

    public void deleteMenuItem(Integer id) {
        menuItemRepository.deleteById(id);
    }
}
