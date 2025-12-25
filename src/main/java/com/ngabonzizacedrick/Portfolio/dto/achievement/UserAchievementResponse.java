package com.ngabonzizacedrick.Portfolio.dto.achievement;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementResponse {
    
    private Long id;
    private AchievementSummary achievement;
    private Boolean unlocked;
    private Integer progressPercentage;
    private LocalDateTime earnedAt;
    private LocalDateTime createdAt;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AchievementSummary {
        private Long id;
        private String title;
        private String description;
        private String iconUrl;
        private String badgeColor;
        private Achievement.AchievementType type;
        private Achievement.AchievementRarity rarity;
        private Integer pointsRequired;
        private Integer challengesRequired;
    }
}