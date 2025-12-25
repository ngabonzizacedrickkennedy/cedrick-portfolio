package com.ngabonzizacedrick.Portfolio.dto.response.auth;

import com.ngabonzizacedrick.Portfolio.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    
    private String token;
    private String tokenType = "Bearer";
    private Long expiresIn; // Seconds until token expires
    private UserProfileResponse user;
}
