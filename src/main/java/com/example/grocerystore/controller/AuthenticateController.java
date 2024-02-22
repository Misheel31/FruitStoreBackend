package com.example.grocerystore.controller;

import com.example.grocerystore.dto.AuthenticateRequest;
import com.example.grocerystore.dto.AuthenticateResponse;
import com.example.grocerystore.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticateController {
    private final AuthenticateService authenticateService;
    @PostMapping("/authenticate")
    public AuthenticateResponse authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
        return authenticateService.authenticate(authenticateRequest);
    }
}
