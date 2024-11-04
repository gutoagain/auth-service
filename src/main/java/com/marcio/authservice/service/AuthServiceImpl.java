package com.marcio.authservice.service;

import com.marcio.authservice.client.UserFeignClient;
import com.marcio.authservice.dto.UserValidationResponse;
import com.marcio.authservice.dto.ValidateUserRequest;
import com.marcio.authservice.util.JwtUtils;
import com.marcio.authservice.vos.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserFeignClient userFeignClient;
    private final JwtUtils jwtUtils;

    @Override
    public AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest) {
        log.info("Starting Validating user credentials");
        UserValidationResponse userValidationResponse = userFeignClient.validateUser(validateUserRequest);
        if(userValidationResponse.getValid()){
            log.info("Successfully validated user {}", validateUserRequest.getUsername());
            return new AuthValidationResponse(jwtUtils.generateToken(validateUserRequest.getUsername()));
        }
        // Como retornar amigavel ao cliente isso aqui?
        log.error("Erro ao gerar token");
        throw new RuntimeException("Token generation failed");
    }
}
