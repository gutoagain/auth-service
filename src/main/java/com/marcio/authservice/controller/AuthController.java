package com.marcio.authservice.controller;

import com.marcio.authservice.dto.ValidateUserRequest;
import com.marcio.authservice.service.AuthService;
import com.marcio.authservice.vos.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/token")
    ResponseEntity<AuthValidationResponse> generateToken(@RequestBody ValidateUserRequest validateUserRequest){
        return ResponseEntity.ok(authService.generateToken(validateUserRequest));
    }
}
