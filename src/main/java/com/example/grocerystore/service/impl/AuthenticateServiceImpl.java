package com.example.grocerystore.service.impl;

import com.example.grocerystore.Security.JwtService;
import com.example.grocerystore.config.PasswordEncoderUtil;
import com.example.grocerystore.dto.AuthenticateRequest;
import com.example.grocerystore.dto.AuthenticateResponse;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.repository.UserRepository;
import com.example.grocerystore.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
    private final UserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(), authenticateRequest.getPassword()
                )
        );
        User user  = userRepo.getUserByUsername(authenticateRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        UserDetails userDetails= user;
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticateResponse
                .builder()
                .token(jwtToken)
                .userID(user.getId())
                .role(user.getId()==1?"Admin":"")
                .build();
    }

    @Override
    public void initiateForgetPassword(String email) {

    }

    @Override
    public boolean validateForgetPasswordOtp(String email, String otp) {
        return false;
    }

    @Override
    public void updatePassword(String email, String newPassword) {

    }

}