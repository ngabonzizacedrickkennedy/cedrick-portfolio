package com.ngabonzizacedrick.Portfolio.dto.progress;

import com.ngabonzizacedrick.Portfolio.model.CodingChallenge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProgressStatsResponse {
    
    private Integer totalChallengesAttempted;
    private Integer totalChallengesCompleted;
    private Integer totalPoints;
    private Double overallSuccessRate;
    private Double averageExecutionTime;
    private Double averageAttempts;
    private Integer currentStreak;
    private Integer longestStreak;
    private Map<CodingChallenge.DifficultyLevel, DifficultyStats> statsByDifficulty;
    private Map<CodingChallenge.ProgrammingLanguage, LanguageStats> statsByLanguage;
    private Integer rank; // User's rank in leaderboard
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DifficultyStats {
        private Integer attempted;
        private Integer completed;
        private Double successRate;
        private Integer pointsEarned;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LanguageStats {
        private Integer attempted;
        private Integer completed;
        private Double successRate;
    }
}