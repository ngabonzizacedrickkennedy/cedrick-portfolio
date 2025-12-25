package com.ngabonzizacedrick.Portfolio.dto.achievement;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAchievementRequest {
    
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;
    
    private String iconUrl;
    
    private String badgeColor;
    
    private Achievement.AchievementType type;
    
    private Achievement.AchievementRarity rarity;
    
    @Min(value = 0, message = "Points required cannot be negative")
    private Integer pointsRequired;
    
    @Min(value = 0, message = "Challenges required cannot be negative")
    private Integer challengesRequired;
    
    private Boolean active;
}
