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
public class AchievementResponse {
    
    private Long id;
    private String title;
    private String description;
    private String iconUrl;
    private String badgeColor;
    private Achievement.AchievementType type;
    private Achievement.AchievementRarity rarity;
    private Integer pointsRequired;
    private Integer challengesRequired;
    private Boolean active;
    private Integer usersEarnedCount;
    private Boolean earnedByCurrentUser;
    private LocalDateTime earnedAt; // If earned by current user
    private Integer progressPercentage; // Current user's progress
    private LocalDateTime createdAt;
}
