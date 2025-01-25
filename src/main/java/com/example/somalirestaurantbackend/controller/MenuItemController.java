package com.example.somalirestaurantbackend.controller;

import com.example.somalirestaurantbackend.model.MenuItem;
import com.example.somalirestaurantbackend.service.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin("*")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItemService.getAllMenuItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(id));
    }

    @PostMapping
    public ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.saveMenuItem(menuItem));
    }

   /* @PostMapping("/{id}/upload-image")
    public ResponseEntity<String> uploadImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        String imageUrl = menuItemService.uploadImage(id, file);
        return ResponseEntity.ok("Image uploaded successfully. URL: " + imageUrl);
    }*/

    @PostMapping("/add")
    public ResponseEntity<MenuItem> saveMenuItemWithImage(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("available") Boolean available,
            @RequestParam("category") String category,
            @RequestParam("file") MultipartFile file) {

        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setDescription(description);
        menuItem.setPrice(price);
        menuItem.setAvailable(available);
        menuItem.setCategory(category);

        MenuItem savedMenuItem = menuItemService.saveMenuItemWithImage(menuItem, file);
        return ResponseEntity.ok(savedMenuItem);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(id, menuItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Integer id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
