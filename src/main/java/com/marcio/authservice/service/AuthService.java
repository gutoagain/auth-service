package com.marcio.authservice.service;

import com.marcio.authservice.dto.ValidateUserRequest;
import com.marcio.authservice.vos.AuthValidationResponse;

public interface AuthService {
    AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest);
}
