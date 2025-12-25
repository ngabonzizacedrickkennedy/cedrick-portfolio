package com.ngabonzizacedrick.Portfolio.dto.progress;

import com.ngabonzizacedrick.Portfolio.model.UserProgress;
import com.ngabonzizacedrick.Portfolio.model.CodingChallenge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProgressResponse {
    
    private Long id;
    private ChallengeInfo challenge;
    private UserProgress.ProgressStatus status;
    private Integer attempts;
    private Integer testCasesPassed;
    private Integer totalTestCases;
    private Double successRate;
    private Long executionTimeMs;
    private Integer memoryUsedMb;
    private Integer pointsEarned;
    private Boolean isOptimalSolution;
    private String feedback;
    private LocalDateTime completedAt;
    private LocalDateTime firstAttemptedAt;
    private LocalDateTime lastAttemptedAt;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeInfo {
        private Long id;
        private String title;
        private String slug;
        private CodingChallenge.DifficultyLevel difficulty;
        private CodingChallenge.ProgrammingLanguage language;
        private Integer points;
    }
}