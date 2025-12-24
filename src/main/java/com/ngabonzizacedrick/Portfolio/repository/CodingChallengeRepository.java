package com.ngabonzizacedrick.Portfolio.repository;

import com.ngabonzizacedrick.Portfolio.model.CodingChallenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodingChallengeRepository extends JpaRepository<CodingChallenge, Long> {
    
    // Basic queries
    Optional<CodingChallenge> findBySlug(String slug);
    
    List<CodingChallenge> findByActive(Boolean active);
    
    Page<CodingChallenge> findByActive(Boolean active, Pageable pageable);
    
    // Difficulty queries
    List<CodingChallenge> findByDifficulty(CodingChallenge.DifficultyLevel difficulty);
    
    Page<CodingChallenge> findByActiveAndDifficulty(
        Boolean active,
        CodingChallenge.DifficultyLevel difficulty,
        Pageable pageable
    );
    
    List<CodingChallenge> findByActiveAndDifficulty(
        Boolean active,
        CodingChallenge.DifficultyLevel difficulty
    );
    
    // Language queries
    List<CodingChallenge> findByLanguage(CodingChallenge.ProgrammingLanguage language);
    
    Page<CodingChallenge> findByActiveAndLanguage(
        Boolean active,
        CodingChallenge.ProgrammingLanguage language,
        Pageable pageable
    );
    
    // Combined queries
    List<CodingChallenge> findByActiveAndDifficultyAndLanguage(
        Boolean active,
        CodingChallenge.DifficultyLevel difficulty,
        CodingChallenge.ProgrammingLanguage language
    );
    
    // Tag queries
    @Query("SELECT c FROM CodingChallenge c WHERE :tag MEMBER OF c.tags AND c.active = true")
    List<CodingChallenge> findByTag(@Param("tag") String tag);
    
    // Search queries
    @Query("SELECT c FROM CodingChallenge c WHERE c.active = true AND " +
           "(LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<CodingChallenge> searchActiveChallenges(@Param("search") String search, Pageable pageable);
    
    // Order by display order
    List<CodingChallenge> findByActiveOrderByDisplayOrderAsc(Boolean active);
    
    List<CodingChallenge> findByActiveAndDifficultyOrderByDisplayOrderAsc(
        Boolean active,
        CodingChallenge.DifficultyLevel difficulty
    );
    
    // Popular challenges
    List<CodingChallenge> findTop10ByActiveOrderByAttemptCountDesc(Boolean active);
    
    List<CodingChallenge> findTop10ByActiveOrderBySuccessCountDesc(Boolean active);
    
    // Success rate queries
    @Query("SELECT c FROM CodingChallenge c WHERE c.active = true AND c.attemptCount > 0 ORDER BY (c.successCount * 100.0 / c.attemptCount) DESC")
    List<CodingChallenge> findByHighestSuccessRate(Pageable pageable);
    
    // Points queries
    List<CodingChallenge> findByActiveOrderByPointsDesc(Boolean active);
    
    @Query("SELECT c FROM CodingChallenge c WHERE c.active = true AND c.points >= :minPoints")
    List<CodingChallenge> findByMinPoints(@Param("minPoints") Integer minPoints);
    
    // Increment counters
    @Modifying
    @Query("UPDATE CodingChallenge c SET c.attemptCount = c.attemptCount + 1 WHERE c.id = :id")
    void incrementAttemptCount(@Param("id") Long id);
    
    @Modifying
    @Query("UPDATE CodingChallenge c SET c.successCount = c.successCount + 1 WHERE c.id = :id")
    void incrementSuccessCount(@Param("id") Long id);
    
    // Count queries
    long countByActive(Boolean active);
    
    long countByDifficulty(CodingChallenge.DifficultyLevel difficulty);
    
    long countByActiveAndDifficulty(Boolean active, CodingChallenge.DifficultyLevel difficulty);
    
    long countByLanguage(CodingChallenge.ProgrammingLanguage language);
    
    // Exists queries
    boolean existsBySlug(String slug);
    
    boolean existsByTitle(String title);
    
    // Creator queries
    List<CodingChallenge> findByCreatedBy_Id(Long userId);
    
    Page<CodingChallenge> findByCreatedBy_Id(Long userId, Pageable pageable);
}