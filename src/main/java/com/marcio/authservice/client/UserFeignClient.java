package com.marcio.authservice.client;

import com.marcio.authservice.dto.UserValidationResponse;
import com.marcio.authservice.dto.ValidateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-managemet-service", url = "http://localhost:8080")
public interface UserFeignClient {
    @PostMapping("/users/validate")
    UserValidationResponse validateUser(@RequestBody ValidateUserRequest validateUserRequest);
}
