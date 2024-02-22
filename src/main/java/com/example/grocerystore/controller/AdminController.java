package com.example.grocerystore.controller;

import com.example.grocerystore.dto.FruitItemDto;
import com.example.grocerystore.dto.UserDto;
import com.example.grocerystore.entity.FruitItem;
import com.example.grocerystore.service.FruitItemService;
import com.example.grocerystore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor

final class AdminController{
    private final FruitItemService itemService;
    private final UserService userService;

    @PatchMapping("/update-item/{itemId}")
    public ResponseEntity<String> updateItem(@PathVariable("itemId") Integer itemId, @RequestBody FruitItemDto itemDto) {
        try {
            itemService.update(itemId, itemDto);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product: " + e.getMessage());
        }
    }

    @PostMapping("/upload-fruit")
    public String uploadItem(@RequestBody FruitItemDto itemDto) {
        itemService.save(itemDto);
        return "Product uploaded";
    }

    @DeleteMapping("/delete-item-by-id/{itemId}")
    public void deleteById(@PathVariable("itemId") Integer itemId) {
        itemService.deleteById(itemId);
    }

    @GetMapping("/allUser")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}