package com.alaToo.scrs.service;

import com.alaToo.scrs.config.JwtService;
import com.alaToo.scrs.dto.AuthResponse;
import com.alaToo.scrs.dto.LoginRequest;
import com.alaToo.scrs.dto.RegisterRequest;
import com.alaToo.scrs.entity.User;
import com.alaToo.scrs.exceptions.CustomException;
import com.alaToo.scrs.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        AuthResponse response = new AuthResponse();
        response.setToken(
                jwtService.generateToken(
                        userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND))
                )
        );
        return response;
    }



        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(
                jwtService.generateToken(userRepository.save(user))
        );
        return authResponse;
    }

}
