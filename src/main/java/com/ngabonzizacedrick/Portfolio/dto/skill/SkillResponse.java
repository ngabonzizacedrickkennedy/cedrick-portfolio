package com.ngabonzizacedrick.Portfolio.dto.skill;

import com.ngabonzizacedrick.Portfolio.model.Skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SkillResponse {
    
    private Long id;
    private String name;
    private String description;
    private Skill.SkillCategory category;
    private Integer proficiency;
    private Double yearsExperience;
    private String iconUrl;
    private Integer displayOrder;
    private Boolean visible;
    private Skill.SkillLevel skillLevel; // Calculated: BEGINNER, INTERMEDIATE, ADVANCED, EXPERT
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}