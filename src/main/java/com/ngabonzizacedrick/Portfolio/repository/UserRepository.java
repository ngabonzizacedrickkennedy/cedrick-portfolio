package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Basic queries
    Optional<User> findByEmail(String email);
    
    Optional<User> findByUsername(String username);
    
    boolean existsByEmail(String email);
    
    boolean existsByUsername(String username);
    
    // Role-based queries
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = :role")
    List<User> findByRole(@Param("role") User.Role role);
    
    List<User> findByRolesContaining(User.Role role);
    
    // Account status queries
    List<User> findByEnabled(Boolean enabled);
    
    List<User> findByAccountNonLocked(Boolean accountNonLocked);
    
    // Password reset queries
    Optional<User> findByResetPasswordToken(String token);
    
    @Query("SELECT u FROM User u WHERE u.resetPasswordToken = :token AND u.resetPasswordTokenExpiry > :now")
    Optional<User> findByValidResetToken(
        @Param("token") String token,
        @Param("now") LocalDateTime now
    );
    
    // Login tracking
    @Query("SELECT u FROM User u WHERE u.lastLoginAt BETWEEN :start AND :end")
    List<User> findUsersLoggedInBetween(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
    
    // Search functionality
    @Query("SELECT u FROM User u WHERE " +
           "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(u.username) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<User> searchUsers(@Param("search") String search);
    
    // Count queries
    long countByRolesContaining(User.Role role);
    
    long countByEnabled(Boolean enabled);
}