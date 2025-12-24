package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserAchievementRepository extends JpaRepository<Achievement.UserAchievement, Long> {
    
    // Basic queries
    Optional<Achievement.UserAchievement> findByUser_IdAndAchievement_Id(Long userId, Long achievementId);
    
    List<Achievement.UserAchievement> findByUser_Id(Long userId);
    
    Page<Achievement.UserAchievement> findByUser_Id(Long userId, Pageable pageable);
    
    List<Achievement.UserAchievement> findByAchievement_Id(Long achievementId);
    
    // Unlocked achievements
    List<Achievement.UserAchievement> findByUser_IdAndUnlocked(Long userId, Boolean unlocked);
    
    Page<Achievement.UserAchievement> findByUser_IdAndUnlockedOrderByEarnedAtDesc(Long userId, Boolean unlocked, Pageable pageable);
    
    // Recent achievements
    @Query("SELECT ua FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.unlocked = true ORDER BY ua.earnedAt DESC")
    List<Achievement.UserAchievement> findRecentUnlocked(@Param("userId") Long userId, Pageable pageable);
    
    // Progress tracking
    List<Achievement.UserAchievement> findByUser_IdAndUnlockedOrderByProgressPercentageDesc(Long userId, Boolean unlocked);
    
    @Query("SELECT ua FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.unlocked = false AND ua.progressPercentage > 0 ORDER BY ua.progressPercentage DESC")
    List<Achievement.UserAchievement> findInProgress(@Param("userId") Long userId);
    
    // Time-based queries
    @Query("SELECT ua FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.earnedAt BETWEEN :start AND :end")
    List<Achievement.UserAchievement> findEarnedBetweenDates(
        @Param("userId") Long userId,
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
    
    // Type-based queries
    @Query("SELECT ua FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.achievement.type = :type AND ua.unlocked = true")
    List<Achievement.UserAchievement> findByUserAndType(
        @Param("userId") Long userId,
        @Param("type") Achievement.AchievementType type
    );
    
    // Rarity-based queries
    @Query("SELECT ua FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.achievement.rarity = :rarity AND ua.unlocked = true")
    List<Achievement.UserAchievement> findByUserAndRarity(
        @Param("userId") Long userId,
        @Param("rarity") Achievement.AchievementRarity rarity
    );
    
    // Count queries
    long countByUser_Id(Long userId);
    
    long countByUser_IdAndUnlocked(Long userId, Boolean unlocked);
    
    long countByAchievement_Id(Long achievementId);
    
    @Query("SELECT COUNT(ua) FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.achievement.type = :type AND ua.unlocked = true")
    long countByUserAndType(
        @Param("userId") Long userId,
        @Param("type") Achievement.AchievementType type
    );
    
    // Exists queries
    boolean existsByUser_IdAndAchievement_Id(Long userId, Long achievementId);
    
    // Statistics
    @Query("SELECT AVG(ua.progressPercentage) FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.unlocked = false")
    Double getAverageProgressPercentage(@Param("userId") Long userId);
    
    @Query("SELECT (COUNT(ua) * 100.0 / (SELECT COUNT(a) FROM Achievement a WHERE a.active = true)) " +
           "FROM Achievement.UserAchievement ua WHERE ua.user.id = :userId AND ua.unlocked = true")
    Double getCompletionPercentage(@Param("userId") Long userId);
}