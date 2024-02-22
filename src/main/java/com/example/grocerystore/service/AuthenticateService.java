package com.example.grocerystore.service;

import com.example.grocerystore.dto.AuthenticateRequest;
import com.example.grocerystore.dto.AuthenticateResponse;

public interface AuthenticateService {
    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
    void initiateForgetPassword(String email);
    boolean validateForgetPasswordOtp(String email, String otp);
    void updatePassword(String email, String newPassword);
}
 