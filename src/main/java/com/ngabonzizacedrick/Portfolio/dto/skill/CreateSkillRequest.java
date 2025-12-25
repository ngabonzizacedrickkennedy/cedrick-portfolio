package com.ngabonzizacedrick.Portfolio.dto.skill;

import com.ngabonzizacedrick.Portfolio.model.Skill;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateSkillRequest {
    
    @NotBlank(message = "Skill name is required")
    @Size(min = 2, max = 100, message = "Skill name must be between 2 and 100 characters")
    private String name;
    
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    
    @NotNull(message = "Category is required")
    private Skill.SkillCategory category;
    
    @NotNull(message = "Proficiency is required")
    @Min(value = 0, message = "Proficiency must be between 0 and 100")
    @Max(value = 100, message = "Proficiency must be between 0 and 100")
    private Integer proficiency;
    
    @Min(value = 0, message = "Years of experience cannot be negative")
    @Max(value = 50, message = "Years of experience cannot exceed 50")
    private Double yearsExperience;
    
    private String iconUrl;
    
    private Integer displayOrder;
    
    private Boolean visible = true;
}