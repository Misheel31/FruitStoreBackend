package com.example.grocerystore.controller;

import com.example.grocerystore.dto.UserDto;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return "User registered successfully";
    }



}
