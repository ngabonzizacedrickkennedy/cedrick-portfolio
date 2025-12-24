package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.CodingChallenge;
import com.ngabonzizacedrick.Portfolio.model.UserProgress;
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
public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    
    // Basic queries
    Optional<UserProgress> findByUser_IdAndChallenge_Id(Long userId, Long challengeId);
    
    List<UserProgress> findByUser_Id(Long userId);
    
    Page<UserProgress> findByUser_Id(Long userId, Pageable pageable);
    
    List<UserProgress> findByChallenge_Id(Long challengeId);
    
    // Status queries
    List<UserProgress> findByUser_IdAndStatus(Long userId, UserProgress.ProgressStatus status);
    
    Page<UserProgress> findByUser_IdAndStatus(Long userId, UserProgress.ProgressStatus status, Pageable pageable);
    
    long countByUser_IdAndStatus(Long userId, UserProgress.ProgressStatus status);
    
    // Completed challenges
    List<UserProgress> findByUser_IdAndStatusOrderByCompletedAtDesc(Long userId, UserProgress.ProgressStatus status);
    
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId AND up.status = 'COMPLETED' ORDER BY up.completedAt DESC")
    List<UserProgress> findRecentCompletedChallenges(@Param("userId") Long userId, Pageable pageable);
    
    // Difficulty-based queries
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId AND up.challenge.difficulty = :difficulty")
    List<UserProgress> findByUserAndDifficulty(
        @Param("userId") Long userId,
        @Param("difficulty") CodingChallenge.DifficultyLevel difficulty
    );
    
    // Points queries
    @Query("SELECT SUM(up.pointsEarned) FROM UserProgress up WHERE up.user.id = :userId")
    Long getTotalPointsByUser(@Param("userId") Long userId);
    
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId ORDER BY up.pointsEarned DESC")
    List<UserProgress> findTopScoringChallenges(@Param("userId") Long userId, Pageable pageable);
    
    // Time-based queries
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId AND up.completedAt BETWEEN :start AND :end")
    List<UserProgress> findCompletedBetweenDates(
        @Param("userId") Long userId,
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end
    );
    
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId AND up.lastAttemptedAt >= :since")
    List<UserProgress> findRecentAttempts(@Param("userId") Long userId, @Param("since") LocalDateTime since);
    
    // Statistics queries
    @Query("SELECT AVG(up.executionTimeMs) FROM UserProgress up WHERE up.user.id = :userId AND up.status = 'COMPLETED'")
    Double getAverageExecutionTime(@Param("userId") Long userId);
    
    @Query("SELECT AVG(up.attempts) FROM UserProgress up WHERE up.user.id = :userId AND up.status = 'COMPLETED'")
    Double getAverageAttempts(@Param("userId") Long userId);
    
    // Success rate
    @Query("SELECT COUNT(up) FROM UserProgress up WHERE up.user.id = :userId AND up.testCasesPassed = up.totalTestCases")
    long countFullyPassedChallenges(@Param("userId") Long userId);
    
    // Leaderboard queries
    @Query("SELECT up.user.id, SUM(up.pointsEarned) as totalPoints FROM UserProgress up WHERE up.status = 'COMPLETED' GROUP BY up.user.id ORDER BY totalPoints DESC")
    List<Object[]> getLeaderboard(Pageable pageable);
    
    @Query("SELECT up FROM UserProgress up WHERE up.challenge.id = :challengeId ORDER BY up.executionTimeMs ASC")
    List<UserProgress> getFastestSolutions(@Param("challengeId") Long challengeId, Pageable pageable);
    
    // Optimal solutions
    List<UserProgress> findByUser_IdAndIsOptimalSolution(Long userId, Boolean isOptimalSolution);
    
    // Count queries
    long countByUser_Id(Long userId);
    
    long countByChallenge_Id(Long challengeId);
    
    // Exists queries
    boolean existsByUser_IdAndChallenge_Id(Long userId, Long challengeId);
    
    // Language-specific progress
    @Query("SELECT up FROM UserProgress up WHERE up.user.id = :userId AND up.challenge.language = :language")
    List<UserProgress> findByUserAndLanguage(
        @Param("userId") Long userId,
        @Param("language") CodingChallenge.ProgrammingLanguage language
    );
    
    @Query("SELECT COUNT(up) FROM UserProgress up WHERE up.user.id = :userId AND up.challenge.language = :language AND up.status = 'COMPLETED'")
    long countCompletedByLanguage(
        @Param("userId") Long userId,
        @Param("language") CodingChallenge.ProgrammingLanguage language
    );
}