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
public class UserProfileResponse {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String bio;
    private String profilePictureUrl;
    private Set<User.Role> roles;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    
    // Helper method to get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    // Helper method to check if admin
    public boolean isAdmin() {
        return roles != null && roles.contains(User.Role.ADMIN);
    }
}