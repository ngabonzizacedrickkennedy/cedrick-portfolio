package com.ngabonzizacedrick.Portfolio.dto.achievement;

import com.ngabonzizacedrick.Portfolio.model.Achievement;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAchievementRequest {
    
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;
    
    private String iconUrl;
    
    private String badgeColor;
    
    @NotNull(message = "Achievement type is required")
    private Achievement.AchievementType type;
    
    @NotNull(message = "Rarity is required")
    private Achievement.AchievementRarity rarity;
    
    @Min(value = 0, message = "Points required cannot be negative")
    private Integer pointsRequired = 0;
    
    @Min(value = 0, message = "Challenges required cannot be negative")
    private Integer challengesRequired = 0;
    
    private Boolean active = true;
}