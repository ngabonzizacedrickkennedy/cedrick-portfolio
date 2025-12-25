package com.ngabonzizacedrick.Portfolio.dto.achievement;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AchievementStatsResponse {
    
    private Integer totalAchievements;
    private Integer unlockedCount;
    private Integer inProgressCount;
    private Integer lockedCount;
    private Double completionPercentage;
    private Map<Achievement.AchievementRarity, Integer> achievementsByRarity;
    private Map<Achievement.AchievementType, Integer> achievementsByType;
}