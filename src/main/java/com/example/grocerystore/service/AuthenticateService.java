package com.example.grocerystore.service;

import com.example.grocerystore.dto.AuthenticateRequest;
import com.example.grocerystore.dto.AuthenticateResponse;

public interface AuthenticateService {
    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
 