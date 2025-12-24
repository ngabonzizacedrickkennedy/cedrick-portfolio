package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    
    // Basic queries
    Optional<Achievement> findByTitle(String title);
    
    List<Achievement> findByActive(Boolean active);
    
    // Type queries
    List<Achievement> findByType(Achievement.AchievementType type);
    
    List<Achievement> findByActiveAndType(Boolean active, Achievement.AchievementType type);
    
    // Rarity queries
    List<Achievement> findByRarity(Achievement.AchievementRarity rarity);
    
    List<Achievement> findByActiveAndRarity(Boolean active, Achievement.AchievementRarity rarity);
    
    // Points queries
    @Query("SELECT a FROM Achievement a WHERE a.active = true AND a.pointsRequired <= :userPoints")
    List<Achievement> findEligibleByPoints(@Param("userPoints") Integer userPoints);
    
    List<Achievement> findByActiveAndPointsRequiredLessThanEqual(Boolean active, Integer points);
    
    // Challenges queries
    @Query("SELECT a FROM Achievement a WHERE a.active = true AND a.challengesRequired <= :completedChallenges")
    List<Achievement> findEligibleByChallenges(@Param("completedChallenges") Integer completedChallenges);
    
    // User achievements
    @Query("SELECT a FROM Achievement a JOIN a.users u WHERE u.id = :userId")
    List<Achievement> findByUserId(@Param("userId") Long userId);
    
    @Query("SELECT COUNT(a) FROM Achievement a JOIN a.users u WHERE u.id = :userId")
    long countByUserId(@Param("userId") Long userId);
    
    // Available achievements (not yet earned by user)
    @Query("SELECT a FROM Achievement a WHERE a.active = true AND a.id NOT IN " +
           "(SELECT a2.id FROM Achievement a2 JOIN a2.users u WHERE u.id = :userId)")
    List<Achievement> findAvailableForUser(@Param("userId") Long userId);
    
    // Popular achievements
    @Query("SELECT a FROM Achievement a WHERE a.active = true ORDER BY SIZE(a.users) DESC")
    List<Achievement> findMostEarned();
    
    // Rare achievements (least earned)
    @Query("SELECT a FROM Achievement a WHERE a.active = true ORDER BY SIZE(a.users) ASC")
    List<Achievement> findLeastEarned();
    
    // Count queries
    long countByActive(Boolean active);
    
    long countByType(Achievement.AchievementType type);
    
    long countByRarity(Achievement.AchievementRarity rarity);
    
    // Exists queries
    boolean existsByTitle(String title);
    
    // Stats
    @Query("SELECT AVG(SIZE(a.users)) FROM Achievement a WHERE a.active = true")
    Double getAverageEarnedCount();
}