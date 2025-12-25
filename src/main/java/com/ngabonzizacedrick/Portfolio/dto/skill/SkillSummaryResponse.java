package com.ngabonzizacedrick.Portfolio.dto.skill;

import com.ngabonzizacedrick.Portfolio.model.Skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SkillSummaryResponse {
    
    private Long id;
    private String name;
    private Skill.SkillCategory category;
    private Integer proficiency;
    private String iconUrl;
    private Skill.SkillLevel skillLevel;
}